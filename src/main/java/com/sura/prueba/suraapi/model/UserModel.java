package com.sura.prueba.suraapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE},
            mappedBy = "users")
    private List<BillsModel> bills;

    public UserModel() {
    }

    public UserModel(String name) {
        this.name = name;
    }

    public UserModel(String name, List<BillsModel> bills) {
        this.name = name;
        this.bills = bills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BillsModel> getBills() {
        return bills;
    }

    public void setBills(List<BillsModel> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bills=" + bills +
                '}';
    }

    public void addBills(BillsModel bill) {
        if(this.bills == null) {
            this.bills = new ArrayList<>();
        }
        this.bills.add(bill);
    }
}
