package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "coin_min_max")
public class CoinMinMaxDAO {

    @EmbeddedId
    private CoinSegmentDAOPK coinOpenDAOPK;

    @Column(name="low")
    private Double minPrice;

    @Column(name="high")
    private Double highPrice;

}
