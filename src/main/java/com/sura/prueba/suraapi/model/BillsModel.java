package com.sura.prueba.suraapi.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="bills")
public class BillsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "bills_date")
    private Date billsDate;

    @Column(name = "bills_total")
    private double billsTotal;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserModel user;

    public BillsModel() {
    }

    public BillsModel(Date billsDate, double billsTotal) {
        this.billsDate = billsDate;
        this.billsTotal = billsTotal;
    }

    public BillsModel(Date billsDate, double billsTotal, UserModel user) {
        this.billsDate = billsDate;
        this.billsTotal = billsTotal;
        this.user = user;
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

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "BillsModel{" +
                "id=" + id +
                ", billsDate=" + billsDate +
                ", billsTotal=" + billsTotal +
                ", user=" + user +
                '}';
    }
}
