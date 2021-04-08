package com.sura.prueba.suraapi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JoinTable(
            name = "bills_users",
            joinColumns = @JoinColumn(name = "id_bill", nullable = false),
            inverseJoinColumns = @JoinColumn(name="id_user", nullable = false)
    )
    private List<UserModel> users;

    public BillsModel() {
    }

    public BillsModel(Date billsDate, double billsTotal) {
        this.billsDate = billsDate;
        this.billsTotal = billsTotal;
    }

    public BillsModel(Date billsDate, double billsTotal, List<UserModel> users) {
        this.billsDate = billsDate;
        this.billsTotal = billsTotal;
        this.users = users;
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

    @Override
    public String toString() {
        return "BillsModel{" +
                "id=" + id +
                ", billsDate=" + billsDate +
                ", billsTotal=" + billsTotal +
                ", user=" + users +
                '}';
    }
}
