package com.automatictrade.data.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Entity(name = "coins")
@AllArgsConstructor
@NoArgsConstructor
public class CoinThemeDAO {

    @EmbeddedId
    private CoinThemeDAOPK coinThemeDTOPK;
}
