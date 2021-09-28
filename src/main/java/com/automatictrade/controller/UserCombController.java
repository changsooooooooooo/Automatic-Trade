package com.automatictrade.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/usercomb")
public class UserCombController {

    @Value("${candle.url}")
    private String url;

    @GetMapping("/bigdiff")
    public Mono<String> recordBigDiffCoins(@RequestParam int count){
        WebClient webClient = WebClient.create(url);
        return webClient.get()
                .uri(uriBuilder->
                        uriBuilder
                                .queryParam("market", "KRW-BTC")
                                .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
