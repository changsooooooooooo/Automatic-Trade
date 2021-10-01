package com.automatictrade.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class CoinThemeDTOPK implements Serializable {

    @Column(name="coin_name")
    @OneToMany(mappedBy = "coinType")
    private List<CoinTradeRecordDTO> coinTradeRecordDTOList = new ArrayList<>();

    @Column(name="coin_category")
    private String coinCategory;

}
