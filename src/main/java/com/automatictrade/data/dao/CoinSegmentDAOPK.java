package com.automatictrade.data.dao;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Getter
@Embeddable
public class CoinSegmentDAOPK implements Serializable {

    @Column(name="code")
    private String code;

    @Column(name="time")
    private String time;
}
