package com.automatictrade.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CoinTradeRecordDTOPK implements Serializable {

    @Column(name="code")
    private String coinType;

    @Column(name="sequential_id")
    private String sequentialID;

}
