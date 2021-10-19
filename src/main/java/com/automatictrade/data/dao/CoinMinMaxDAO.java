package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "coin_min_max")
public class CoinMinMaxDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="coin_name")
    private CoinDAO coinDAO;

    @Column(name="time")
    private String time;

    @Column(name="low")
    private Double minPrice;

    @Column(name="high")
    private Double highPrice;

}
