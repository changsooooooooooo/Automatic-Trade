package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "coin_accum_volume")
public class CoinAcuumVolumeDAO {

    @EmbeddedId
    private CoinSegmentDAOPK coinAccumVolumeDAOPK;

    @Column(name="volume")
    private Double volume;

    @Column(name="accumulate_volume")
    private Double accumulateVolume;
}
