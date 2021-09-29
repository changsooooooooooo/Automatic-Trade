package com.automatictrade.service;

import com.automatictrade.dto.CoinDayCandleDTO;
import com.automatictrade.exceptions.FunctionWithException;
import com.automatictrade.exceptions.ServiceLogicException;
import com.automatictrade.repository.CoinDBRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class RecordLogic {

    @Value("${candle.url}")
    private String candleUrl;

    private final CoinDBRepository coinDBRepository;

    public Flux<String> getBigDiffCand(final int count) {
        WebClient webClient = WebClient.create(candleUrl);
        List<String> coinList = coinDBRepository.findDistinctCoins();
        return Flux.interval(Duration.ofSeconds(2))
                .map(tick->coinList.subList(tick.intValue()*10,
                        Math.min(coinList.size(), (tick.intValue()+1)*10)))
                .flatMap(list->makeSubResult(list, webClient))
                .sort(Comparator.comparing(dto->dto.getLowPrice()-dto.getHighPrice()))
                .take(count)
                .map(dto->dto.getMarket());
    }

    public Flux<CoinDayCandleDTO> makeSubResult(final List<String> coinList, final WebClient webClient){
        return Flux.fromIterable(coinList)
                .map(coin->getDayCandle(coin, webClient))
                .flatMap(mono->strToCandleDTO(mono));
    }

    public Mono<String> getDayCandle(final String coinName, final WebClient webClient) {
        return webClient.get()
                .uri(uriBuilder->
                        uriBuilder.queryParam("market", coinName)
                                .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response->response.bodyToMono(String.class))
                .log();
    }

    public Mono<CoinDayCandleDTO> strToCandleDTO(final Mono<String> clientContent) {
        ObjectMapper mapper = new ObjectMapper();
        return clientContent.map(str->String.valueOf(new JSONArray(str).get(0)))
                .map(wrapper(json->mapper.readValue(json, CoinDayCandleDTO.class)))
                .filter(dto->dto.getClass().equals(CoinDayCandleDTO.class));
    }

    private <T, R> Function<T, R> wrapper(final FunctionWithException<T, R> fe) {
        return arg -> {
            try {
                return fe.apply(arg);
            } catch (Exception e) {
                throw new ServiceLogicException("Check Record TO DTO Service Logic", e.getCause());
            }
        };
    }
}
