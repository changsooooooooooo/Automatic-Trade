package com.automatictrade.controller;

import com.automatictrade.service.RecordLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/usercomb")
public class UserCombController {

    private final RecordLogic recordLogic;

    @GetMapping("/bigdiff")
    public List<String> recordBigDiffCoins(@RequestParam int count) {
        return recordLogic.getBigDiffCand(count)
                .toStream()
                .collect(Collectors.toList());
    }
}
