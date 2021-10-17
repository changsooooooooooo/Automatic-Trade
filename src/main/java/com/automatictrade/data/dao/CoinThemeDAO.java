package com.automatictrade.data.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Builder
@Entity(name = "coins")
@AllArgsConstructor
@NoArgsConstructor
public class CoinThemeDAO {

    @EmbeddedId
    private CoinThemeDAOPK coinThemeDTOPK;
}
