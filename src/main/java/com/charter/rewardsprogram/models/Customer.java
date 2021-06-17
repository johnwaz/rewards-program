package com.charter.rewardsprogram.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy="customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Purchase> purchases;

    private Long rewardPoints;

    private Long totalPurchases;

    public Customer() {
        super();
    }

    public Customer(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Long getRewardPoints() {
        if (purchases == null || purchases.isEmpty()) return 0L;
        return purchases.stream().map(x -> x.getPoints().intValue()).reduce(0, Integer::sum).longValue();
    }

    public void setRewardPoints(Long rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Long getTotalPurchases() {
        if (purchases == null || purchases.isEmpty()) return 0L;
        return purchases.stream().map(x -> x.getTotal().intValue()).reduce(0, Integer::sum).longValue();
    }

    public void setTotalPurchases(Long totalPurchases) {
        this.totalPurchases = totalPurchases;
    }
}
