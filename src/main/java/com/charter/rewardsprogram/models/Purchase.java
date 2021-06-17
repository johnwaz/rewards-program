package com.charter.rewardsprogram.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Purchase extends Reward {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Customer customer;

    private Long total;

    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    public Purchase() {
        super();
    }

    public Purchase(Integer id, Customer customer, Long total, Date date) {
        super();
        this.id = id;
        this.customer = customer;
        this.total = total;
        this.purchaseDate = date;
    }

    @Override
    public Long getPoints() {
        this.points = 0L;

        if (this.total > 50 && this.total <= 100) {
            this.points += (this.total.intValue() - 50);

        }

        if (this.total > 100) {
            this.points += 50;
            this.points += (this.total.intValue() - 100) * 2L;
        }

        return this.points;
    }

    public Integer getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
