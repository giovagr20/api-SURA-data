package com.sura.prueba.suraapi.service;

import com.sura.prueba.suraapi.helper.UserDTO;
import com.sura.prueba.suraapi.model.BillsModel;
import com.sura.prueba.suraapi.model.UserModel;
import com.sura.prueba.suraapi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.sura.prueba.suraapi.helper.generic.UserHelper.userFromDTO;

@Service
public class UserService implements IUserService {

    private static final double IVA = 0.19;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IBillService billService;

    @Override
    public List<UserModel> findAll() {
        return (List<UserModel>) userRepository.findAll();
    }

    @Override
    public List<UserModel> findAllWithoutBill() {
        List<UserModel> userModel = userRepository.findAll();
        userModel = userModel.stream().map(user -> userFromDTO(
                new UserDTO(user))).collect(Collectors.toList());
        return userModel;
    }

    @Override
    public UserModel findById(int id) {
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }


    @Override
    public void save(UserModel user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public String addUserBill(UserModel user, BillsModel bill) {
        Optional<UserModel> userModel = userRepository.findById(user.getId());
        if (userModel.isPresent()) {
            userModel.get().getBills().add(bill);
            BillsModel billsModel = billService.findById(bill.getId());
            billsModel.getUser().add(userModel.get());
            userRepository.save(userModel.get());
            return "Success association";
        }
        return null;
    }

    @Override
    public List<String> getUserBillTotal(int id) {
        List<String> returnString = new ArrayList<>();
        Optional<UserModel> user = userRepository.findById(id);


        if (user.isPresent()) {
            returnString.add("user: " + user.get().getName());
            double total = user.get()
                    .getBills()
                    .stream()
                    .mapToDouble(num -> num.getBillsTotal())
                    .sum();
            total = total + total * IVA;
            returnString.add("total: " + total);
            if (total > 1000000) {
                returnString.add("mensaje: Los gatos los asume el empleado");
            } else {
                returnString.add("mensaje: Los gatos los asume el empleador");
            }
            return returnString;
        }
        return null;
    }
}
