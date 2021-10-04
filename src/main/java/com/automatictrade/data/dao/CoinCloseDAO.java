package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "coin_close")
public class CoinCloseDAO {

    @EmbeddedId
    private CoinSegmentDAOPK coinOpenDAOPK;

    @Column(name="close")
    private Double closePrice;
}
