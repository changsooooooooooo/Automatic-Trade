package com.automatictrade.data.dao;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CoinThemeDAOPK implements Serializable {

    @Column(name="coin_name")
    private String coinName;

    @Column(name="coin_category")
    private String coinCategory;

}
