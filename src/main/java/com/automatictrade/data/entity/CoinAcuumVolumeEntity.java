package com.automatictrade.data.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "coin_accum_volume")
public class CoinAcuumVolumeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="coin_name")
    private CoinEntity coinDAO;

    @Column(name="time")
    private String time;

    @Column(name="volume")
    private Double volume;

    @Column(name="accumulate_volume")
    private Double accumulateVolume;

    @Builder
    public CoinAcuumVolumeEntity(CoinEntity coinDAO, String time, Double volume, Double accumulateVolume){
        this.coinDAO = coinDAO;
        this.time = time;
        this.volume = volume;
        this.accumulateVolume = accumulateVolume;
    }
}
