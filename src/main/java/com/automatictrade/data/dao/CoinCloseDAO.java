package com.automatictrade.data.dao;

import lombok.Getter;
import org.joda.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Getter
@Table(name = "coin_close")
public class CoinCloseDAO {

    @EmbeddedId
    private CoinSegmentDAOPK coinCloseDAOPK;

    @Column(name="close")
    private Double closePrice;
}
