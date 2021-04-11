package com.sura.prueba.suraapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "bills")
public class BillsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "bills_date")
    private Date billsDate;

    @Column(name = "bills_total")
    private double billsTotal;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(
            name = "bills_users",
            joinColumns = @JoinColumn(name = "id_bill", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_user", nullable = false)
    )
    private List<UserModel> users;

    public BillsModel() {
    }

    public BillsModel(Date billsDate, double billsTotal) {
        this.billsDate = billsDate;
        this.billsTotal = billsTotal;
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

    public List<UserModel> getUser() {
        return users;
    }

    public void setUser(List<UserModel> users) {
        this.users = users;
    }

}
