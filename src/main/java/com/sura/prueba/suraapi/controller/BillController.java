package com.sura.prueba.suraapi.controller;

import com.sura.prueba.suraapi.model.BillsModel;
import com.sura.prueba.suraapi.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/bills")
    public List<BillsModel> findAll() {
        return billService.findAll();
    }

    @GetMapping("/bills/{billId}")
    public BillsModel getBills(@PathVariable int billId) {
        BillsModel bill = billService.findById(billId);

        if (bill == null) {
            throw new RuntimeException("User id not found -" + bill);
        }
        //retornará al usuario con id pasado en la url
        return bill;
    }

}
