package com.sura.prueba.suraapi.dto.dao;

import com.sura.prueba.suraapi.model.BillsModel;

import java.util.List;

public interface IBillsDAO {

    public List<BillsModel> findAll();

    public BillsModel findById(int id);

    public void save(BillsModel bill);

    public void deleteById(int id);
}
