package com.sura.prueba.suraapi.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE},
            mappedBy = "users")
    @JsonManagedReference
    private List<BillsModel> bills;

    public UserModel() {
    }

    public UserModel(int idUser, String name) {
        this.idUser = idUser;
        this.name = name;
    }

    public UserModel(String name) {
        this.name = name;
    }

    public UserModel(String name, List<BillsModel> bills) {
        this.name = name;
        this.bills = bills;
    }

    public int getId() {
        return idUser;
    }

    public void setId(int idUser) {
        this.idUser = idUser;
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

    public void addBills(BillsModel bill) {
        if (this.bills == null) {
            this.bills = new ArrayList<>();
        }
        this.bills.add(bill);
    }
}
