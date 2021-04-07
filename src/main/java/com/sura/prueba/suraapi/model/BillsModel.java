package com.sura.prueba.suraapi.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="bills")
public class BillsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="bills_date")
    private Date billsDate;

    @Column(name="bills_total")
    private double billsTotal;

    @Column(name="created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    public BillsModel() {
    }

    public BillsModel(Date billsDate, double billsTotal, Date createdAt, Date updatedAt) {
        this.billsDate = billsDate;
        this.billsTotal = billsTotal;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBillsDate() {
        return billsDate;
    }

    public void setBillsDate(Date billsDate) {
        this.billsDate = billsDate;
    }

    public double getBillsTotal() {
        return billsTotal;
    }

    public void setBillsTotal(double billsTotal) {
        this.billsTotal = billsTotal;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BillsModel{" +
                "id=" + id +
                ", billsDate=" + billsDate +
                ", billsTotal=" + billsTotal +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
