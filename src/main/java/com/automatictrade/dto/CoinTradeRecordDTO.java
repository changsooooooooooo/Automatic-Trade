package com.automatictrade.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coin-trade")
@AllArgsConstructor
@NoArgsConstructor
public class CoinTradeRecordDTO {

    @Id
    @Column(name="sequential_id")
    private String sequentialID;

    @Column(name="code")
    private String code;

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
    private

    @Column(name="change_price")
    private Double changePrice;

    @Column(name="trade_date")
    private

    @Column(name="trade_timestamp")
    private

    @Column(name="timestamp")
    private

    @Column(name="trade_price")
    private Double tradePrice;

    @Column(name="prev_closing_price")
    private Double prevClosingPrice;

}
