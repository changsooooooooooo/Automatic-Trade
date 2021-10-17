package com.automatictrade.data.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CoinTradeRecordDAOPK implements Serializable {

    @Column(name="code")
    @JsonProperty("cd")
    private String coinType;

    @Column(name="sequential_id")
    @JsonProperty("sid")
    private String sequentialID;

}
