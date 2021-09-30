package com.automatictrade.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Embeddable
public class CoinTradeRecordDTOPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="coin_name")
    @Column(name="code")
    @JsonProperty("cd")
    private CoinThemeDTO coinType;

    @Column(name="sequential_id")
    @JsonProperty("sid")
    private String sequentialID;

}
