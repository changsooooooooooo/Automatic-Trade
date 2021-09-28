package com.automatictrade.service;

import com.automatictrade.repository.CoinDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordLogic {

    @Value("${candle.url}")
    private String candleUrl;

    private final CoinDBRepository coinDBRepository;

    public void getBigDiffCand(int count){
        List<String> coinList = coinDBRepository.findDistinctCoins();
    }

}
