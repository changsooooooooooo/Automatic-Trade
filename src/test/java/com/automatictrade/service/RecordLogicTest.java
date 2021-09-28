package com.automatictrade.service;

import com.automatictrade.controller.UserCombController;
import com.automatictrade.dto.CoinDayCandleDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebFluxTest(controllers = UserCombController.class)
class RecordLogicTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getBigDiffCandTest() throws JsonProcessingException {
        EntityExchangeResult<byte[]> x = webTestClient.get()
                .uri(uriBuilder->uriBuilder.path("/usercomb/bigdiff")
                        .queryParam("count", "1")
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectBody()
                .returnResult();

        String jsonString = String.valueOf(new JSONArray(new String(x.getResponseBody()))
                .get(0));
        ObjectMapper mapper = new ObjectMapper();

        CoinDayCandleDTO candleDTO = mapper.readValue(jsonString, CoinDayCandleDTO.class);
        System.out.println(candleDTO.getHighPrice());

    }
}
