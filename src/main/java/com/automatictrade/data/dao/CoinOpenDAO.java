package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "coin_open")
public class CoinOpenDAO {

    @EmbeddedId
    private CoinSegmentDAOPK coinOpenDAOPK;

    @Column(name="open")
    private Double openPrice;

}
