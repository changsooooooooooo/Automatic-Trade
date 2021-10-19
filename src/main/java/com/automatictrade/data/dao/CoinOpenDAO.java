package com.automatictrade.data.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "coin_open")
public class CoinOpenDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="coin_name")
    private CoinDAO coinDAO;

    @Column(name="time")
    private String time;

    @Column(name="open")
    private Double openPrice;

}
