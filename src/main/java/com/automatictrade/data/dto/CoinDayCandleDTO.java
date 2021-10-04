package com.automatictrade.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CoinDayCandleDTO {

    @JsonProperty("market")
    private String market;

    @JsonProperty("candle_date_time_utc")
    private String candleDateTimeUTC;

    @JsonProperty("candle_date_time_kst")
    private String candleDateTimeKST;

    @JsonProperty("opening_price")
    private Long openingPrice;

    @JsonProperty("high_price")
    private Long highPrice;

    @JsonProperty("low_price")
    private Long lowPrice;

    @JsonProperty("trade_price")
    private Long tradePrice;

    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("candle_acc_trade_price")
    private Double candleAccTradePrice;

    @JsonProperty("candle_acc_trade_volume")
    private Double candleAccTradeVolume;

    @JsonProperty("prev_closing_price")
    private Long prevClosingPrice;

    @JsonProperty("change_price")
    private Long changePrice;

    @JsonProperty("change_rate")
    private Double changeRate;

}
