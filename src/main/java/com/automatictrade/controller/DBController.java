package com.automatictrade.controller;

import com.automatictrade.service.TransferLogic;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/db")
public class DBController {

    private final TransferLogic transferLogic;

    @GetMapping("/deletedb")
    public String truncateDBbySchedule(){
        transferLogic.truncateDB();
        return makeStatusResult();
    }

    @GetMapping("/updatedb")
    public String updateDBbySchedule(){
        transferLogic.saveToDB();
        return makeStatusResult();
    }

    public String makeStatusResult(){
        return Map.of("Http Status", HttpStatus.OK.value())
                .toString();
    }
}
