package com.automatictrade.dto;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Embeddable
public class CoinTrainDTOPK implements Serializable {

    @Column(name="market")
    private String market;

    @Column(name="time")
    private LocalDateTime time;
}
