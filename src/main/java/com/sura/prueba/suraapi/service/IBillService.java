package com.sura.prueba.suraapi.service;

import com.sura.prueba.suraapi.model.BillsModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBillService {

    List<BillsModel> findAll();

    BillsModel findById(int id);

    void save(BillsModel bill);

    void deleteById(int id);
}
