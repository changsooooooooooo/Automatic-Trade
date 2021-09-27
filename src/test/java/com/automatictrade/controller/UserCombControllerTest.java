package com.automatictrade.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest(controllers = UserCombController.class)
class UserCombControllerTest {

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
