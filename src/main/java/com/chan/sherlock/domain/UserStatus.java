package com.chan.sherlock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer minRentalPeriod;
    private Integer maxRentalPeriod;
    private Integer discount;

    public UserStatus(){

    }

    public UserStatus(Integer minRentalPeriod, Integer maxRentalPeriod, Integer discount){
        this.minRentalPeriod = minRentalPeriod;
        this.maxRentalPeriod = maxRentalPeriod;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMinRentalPeriod() {
        return minRentalPeriod;
    }

    public void setMinRentalPeriod(Integer minRentalPeriod) {
        this.minRentalPeriod = minRentalPeriod;
    }

    public Integer getMaxRentalPeriod() {
        return maxRentalPeriod;
    }

    public void setMaxRentalPeriod(Integer maxRentalPeriod) {
        this.maxRentalPeriod = maxRentalPeriod;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
