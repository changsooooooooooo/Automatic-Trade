package com.automatictrade.service;

import com.automatictrade.controller.UserCombController;
import com.automatictrade.dto.CoinDayCandleDTO;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest(controllers = UserCombController.class)
class RecordLogicTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getBigDiffCandTest()  {
        EntityExchangeResult<byte[]> x = webTestClient.get()
                .uri(uriBuilder->uriBuilder.path("/usercomb/bigdiff")
                        .queryParam("count", "1")
                        .build())
                .exchange()
                .expectBody()
                .returnResult();
        System.out.println(x);
    }

}
