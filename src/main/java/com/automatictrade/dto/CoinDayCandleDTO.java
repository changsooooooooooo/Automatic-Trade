package com.automatictrade.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CoinDayCandleDTO {

    private final String market;
    private final String candleDateTimeUTC;
    private final String candleDateTimeKST;
    private final int openingPrice;
    private final int highPrice;
    private final int lowPrice;
    private final int tradePrice;
    private final int timestamp;
    private final Double candleAccTradePrice;
    private final Double candleAccTradeVolume;
    private final int prevClosingPrice;
    private final int changePrice;
    private final Double changeRate;

}
