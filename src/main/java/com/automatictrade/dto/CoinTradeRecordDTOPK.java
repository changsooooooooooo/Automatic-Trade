package com.automatictrade.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
public class CoinTradeRecordDTOPK implements Serializable {

    @Column(name="code")
    @JsonProperty("cd")
    private String coinType;

    @Column(name="sequential_id")
    @JsonProperty("sid")
    private String sequentialID;

}
