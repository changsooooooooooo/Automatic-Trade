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
    private CoinSegmentDAOPK coinOpenDAOPK;

    @Column(name="accumulated_volume")
    private Double accumulatedVolume;
}
