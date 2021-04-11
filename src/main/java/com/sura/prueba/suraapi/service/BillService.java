package com.sura.prueba.suraapi.service;

import com.sura.prueba.suraapi.model.BillsModel;
import com.sura.prueba.suraapi.repository.IBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillService implements IBillService {

    @Autowired
    IBillRepository billRepository;

    @Override
    public List<BillsModel> findAll() {
        List<BillsModel> list = new ArrayList<>();
        billRepository.findAll().forEach(obj -> list.add(obj));
        return list;
    }

    @Override
    public BillsModel findById(int id) {
        Optional<BillsModel> dao = billRepository.findById(id);
        if (dao.isPresent()) {
            return dao.get();
        }
        return null;
    }


    @Override
    public void save(BillsModel bill) {
        billRepository.save(bill);
    }

    @Override
    public void deleteById(int id) {
        billRepository.deleteById(id);
    }
}
