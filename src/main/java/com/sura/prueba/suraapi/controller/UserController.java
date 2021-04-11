package com.sura.prueba.suraapi.controller;

import com.sura.prueba.suraapi.model.BillsModel;
import com.sura.prueba.suraapi.model.UserModel;
import com.sura.prueba.suraapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    IUserService userService;
    @Autowired
    BillController billController;

    @GetMapping("/users")
    public List<UserModel> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/getUserBillTotal/{id}")
    public List<String> getUserBillTotal(@PathVariable int id) {
        return userService.getUserBillTotal(id);
    }

    @GetMapping("/users/{userId}")
    public UserModel getUser(@PathVariable int userId) {
        UserModel user = userService.findById(userId);
        if (user == null) {
            throw new RuntimeException("User id not found -" + userId);
        }
        return user;
    }

    @GetMapping("/init")
    public String initUserBill() {
        UserModel adam = getUser(1);
        BillsModel billsModelAdam1 = billController.getBills(1);
        BillsModel billsModelAdam2 = billController.getBills(2);
        BillsModel billsModelAdam3 = billController.getBills(10);
        userService.addUserBill(adam, billsModelAdam1);
        userService.addUserBill(adam, billsModelAdam2);
        userService.addUserBill(adam, billsModelAdam3);
        UserModel bolton = getUser(2);
        BillsModel billsModelBolton1 = billController.getBills(3);
        BillsModel billsModelBolton2 = billController.getBills(5);
        BillsModel billsModelBolton3 = billController.getBills(11);
        userService.addUserBill(bolton, billsModelBolton1);
        userService.addUserBill(bolton, billsModelBolton2);
        userService.addUserBill(bolton, billsModelBolton3);
        UserModel chelsea = getUser(3);
        BillsModel billsModelChelsea1 = billController.getBills(4);
        BillsModel billsModelChelsea2 = billController.getBills(9);
        BillsModel billsModelChelsea3 = billController.getBills(13);
        userService.addUserBill(chelsea, billsModelChelsea1);
        userService.addUserBill(chelsea, billsModelChelsea2);
        userService.addUserBill(chelsea, billsModelChelsea3);
        UserModel elsy = getUser(4);
        BillsModel billsModelElsy = billController.getBills(7);
        userService.addUserBill(elsy, billsModelElsy);
        UserModel vincent = getUser(5);
        BillsModel billsModelVincent = billController.getBills(8);
        userService.addUserBill(vincent, billsModelVincent);
        UserModel warden = getUser(6);
        BillsModel billsModelWarden1 = billController.getBills(6);
        BillsModel billsModelWarden2 = billController.getBills(12);
        userService.addUserBill(warden, billsModelWarden1);
        userService.addUserBill(warden, billsModelWarden2);
        return "Iniciado con exito";
    }
}
