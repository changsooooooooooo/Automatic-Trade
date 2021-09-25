package com.automatictrade.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "coin_trade")
@AllArgsConstructor
@NoArgsConstructor
public class CoinTradeRecordDTO {

    @EmbeddedId
    private CoinTradeRecordDTOPK coinTradeRecordDTOPK;

    @Column(name="ask_bid")
    private String tradeType;

    @Column(name="stream_type")
    private String streamType;

    @Column(name="trade_volume")
    private Double tradeVolume;

    @Column(name="change_type")
    private String changeType;

    @Column(name="data_type")
    private String dataType;

    @Column(name="trade_time")
    private LocalTime tradeTime;

    @Column(name="change_price")
    private Double changePrice;

    @Column(name="trade_date")
    private LocalDate tradeDate;

    @Column(name="trade_timestamp")
    private LocalDateTime tradeTimestamp;

    @Column(name="timestamp")
    private LocalDateTime timestamp;

    @Column(name="trade_price")
    private Double tradePrice;

    @Column(name="prev_closing_price")
    private Double prevClosingPrice;

}
