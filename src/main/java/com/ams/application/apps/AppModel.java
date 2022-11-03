package com.ams.application.apps;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.UUID;

@Entity
@Table
public class AppModel {
    @Id
    @GeneratedValue()
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID appId;
    private BigInteger amount;

    public AppModel(UUID appId, BigInteger amount, Float interest, Integer tenure) {
        this.appId = appId;
        this.amount = amount;
        this.interest = interest;
        this.tenure = tenure;
    }
    public AppModel() {}

    private Float interest;
    private Integer tenure;


    public UUID getAppId() {
        return appId;
    }

    public void setAppId(UUID appId) {
        this.appId = appId;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }
}
