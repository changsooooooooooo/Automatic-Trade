package com.automatictrade.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "coin_theme")
@NoArgsConstructor
public class CoinThemeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="coin_name")
    private CoinEntity coinDAO;

    @Column(name="coin_category")
    private String coinCategory;

    @Builder
    public CoinThemeEntity(CoinEntity coinDAO, String coinCategory){
        this.coinDAO = coinDAO;
        this.coinCategory = coinCategory;
    }
}
