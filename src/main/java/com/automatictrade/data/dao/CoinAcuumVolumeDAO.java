package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity(name = "coin_accum_volume")
public class CoinAcuumVolumeDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="coin_name")
    private CoinDAO coinDAO;

    @Column(name="time")
    private String time;

    @Column(name="volume")
    private Double volume;

    @Column(name="accumulate_volume")
    private Double accumulateVolume;
}
