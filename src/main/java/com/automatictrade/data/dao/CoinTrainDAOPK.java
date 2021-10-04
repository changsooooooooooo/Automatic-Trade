package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Embeddable
public class CoinTrainDAOPK implements Serializable {

    @Column(name="market")
    private String market;

    @Column(name="time")
    private Timestamp time;
}
