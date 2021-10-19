package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "coin_close")
public class CoinCloseDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="coin_name")
    private CoinDAO coinDAO;

    @Column(name="time")
    private String time;

    @Column(name="close")
    private Double closePrice;
}
