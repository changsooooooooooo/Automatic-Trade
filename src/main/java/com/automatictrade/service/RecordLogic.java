package com.automatictrade.service;

import com.automatictrade.dto.CoinDayCandleDTO;
import com.automatictrade.repository.CoinDBRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecordLogic {

    @Value("${candle.url}")
    private String candleUrl;

    private final CoinDBRepository coinDBRepository;

    public List<Mono<String>> getBigDiffCand(int count){
        List<String> coinList = coinDBRepository.findDistinctCoins();
        return coinList.stream()
                .map(coin->getCandle(coin))
                .sorted()
                .collect(Collectors.toList());
    }

    public Mono<String> getCandle(String coinName){
        WebClient webClient = WebClient.create(candleUrl);
        return webClient.get()
                .uri(uriBuilder->
                        uriBuilder
                                .queryParam("market", coinName)
                                .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
    }

    public void monoToCandleDTO(Mono<String> clientContent){
        ObjectMapper mapper = new ObjectMapper();
        return clientContent.map(content->new JSONArray(content).get(0))
                .map(json->mapper.readValue(json.toString(), CoinDayCandleDTO.class))

    }

}
