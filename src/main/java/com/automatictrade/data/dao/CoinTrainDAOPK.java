package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Embeddable
public class CoinTrainDAOPK implements Serializable {

    @Column(name="market")
    private String market;

    @Column(name="time")
    private LocalDateTime time;
}
