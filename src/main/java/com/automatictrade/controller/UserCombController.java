package com.automatictrade.controller;

import com.automatictrade.dto.CoinDayCandleDTO;
import com.automatictrade.service.RecordLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/usercomb")
public class UserCombController {

    private final RecordLogic recordLogic;

    @GetMapping("/bigdiff")
    public Mono<List<CoinDayCandleDTO>> recordBigDiffCoins(@RequestParam int count) {
        return recordLogic.getBigDiffCand(count);
    }
}
