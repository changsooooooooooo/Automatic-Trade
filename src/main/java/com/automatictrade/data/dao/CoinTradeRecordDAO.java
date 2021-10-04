package com.automatictrade.data.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "coin_trade")
@AllArgsConstructor
@NoArgsConstructor
public class CoinTradeRecordDAO {

    @EmbeddedId
    @JsonUnwrapped
    private CoinTradeRecordDAOPK coinTradeRecordDTOPK;

    @Column(name="ask_bid")
    @JsonProperty("ab")
    private String tradeType;

    @Column(name="stream_type")
    @JsonProperty("st")
    private String streamType;

    @Column(name="trade_volume")
    @JsonProperty("tv")
    private Double tradeVolume;

    @Column(name="change_type")
    @JsonProperty("c")
    private String changeType;

    @Column(name="data_type")
    @JsonProperty("ty")
    private String dataType;

    @Column(name="trade_time")
    @JsonProperty("ttm")
    private String tradeTime;

    @Column(name="change_price")
    @JsonProperty("cp")
    private Double changePrice;

    @Column(name="trade_date")
    @JsonProperty("td")
    private String tradeDate;

    @Column(name="trade_timestamp")
    @JsonProperty("ttms")
    private Long tradeTimestamp;

    @Column(name="timestamp")
    @JsonProperty("tms")
    private Long timestamp;

    @Column(name="trade_price")
    @JsonProperty("tp")
    private Double tradePrice;

    @Column(name="prev_closing_price")
    @JsonProperty("pcp")
    private Double prevClosingPrice;

}