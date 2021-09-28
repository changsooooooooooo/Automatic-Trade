package com.automatictrade.controller;

import com.automatictrade.service.RecordLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/usercomb")
public class UserCombController {

    private final RecordLogic recordLogic;

    @GetMapping("/bigdiff")
    public Flux<String> recordBigDiffCoins(@RequestParam int count) {
        return recordLogic.getBigDiffCand(count);
    }
}
