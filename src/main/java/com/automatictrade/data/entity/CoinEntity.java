package com.automatictrade.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name="coin_list")
public class CoinEntity {

    @Id
    @Column(name="coin_name")
    private String coinName;

    @OneToMany(mappedBy = "coinDAO", cascade = CascadeType.ALL)
    private final List<CoinThemeEntity> coinThemeDAOList = new ArrayList<>();

    @Builder
    public CoinEntity(String coinName){
        this.coinName = coinName;
    }
}
