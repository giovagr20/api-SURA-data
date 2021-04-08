package com.sura.prueba.suraapi.model;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "user")
    private Set<BillsModel> bills;

    public UserModel() {
    }

    public UserModel(String name) {
        this.name = name;
    }

    public UserModel(String name, Set<BillsModel> bills) {
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

    public Set<BillsModel> getBills() {
        return bills;
    }

    public void setBills(Set<BillsModel> bills) {
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
}
