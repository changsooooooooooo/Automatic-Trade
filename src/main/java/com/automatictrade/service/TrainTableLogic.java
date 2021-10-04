package com.automatictrade.service;

import com.automatictrade.repository.CoinTrainDBRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainTableLogic {

    private final CoinTrainDBRepository coinTrainDBRepository;

    public void formTrainTable(){
//        coinTrainDBRepository.insertToTable();
    }

}
