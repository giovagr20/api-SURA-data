package com.sura.prueba.suraapi.helper;

import com.sura.prueba.suraapi.model.BillsModel;

import java.util.Date;

public class BillsDTO {

    private int id;

    private Date billsDate;

    private double billsTotal;

    public BillsDTO(BillsModel bill) {
        this.id = bill.getId();
        this.billsDate = bill.getBillsDate();
        this.billsTotal = bill.getBillsTotal();
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
}
