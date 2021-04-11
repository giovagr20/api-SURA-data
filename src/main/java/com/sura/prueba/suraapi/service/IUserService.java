package com.sura.prueba.suraapi.service;

import com.sura.prueba.suraapi.model.BillsModel;
import com.sura.prueba.suraapi.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    List<UserModel> findAll();

    List<UserModel> findAllWithoutBill();

    UserModel findById(int id);

    void save(UserModel user);

    void deleteById(int id);

    String addUserBill(UserModel user, BillsModel bill);

    List<String> getUserBillTotal(int id);

}
