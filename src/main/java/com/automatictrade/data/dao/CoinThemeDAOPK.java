package com.automatictrade.data.dao;

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
public class CoinThemeDAOPK implements Serializable {

    @Column(name="coin_name")
    private String coinName;

    @Column(name="coin_category")
    private String coinCategory;

}
