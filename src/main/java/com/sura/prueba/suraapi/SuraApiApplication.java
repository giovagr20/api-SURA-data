package com.sura.prueba.suraapi;

import com.sura.prueba.suraapi.model.BillsModel;
import com.sura.prueba.suraapi.model.UserModel;
import com.sura.prueba.suraapi.service.IBillService;
import com.sura.prueba.suraapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@SpringBootApplication
public class SuraApiApplication {
    @Autowired
    IUserService userService;
    @Autowired
    IBillService billService;

    public static void main(String[] args) {
        SpringApplication.run(SuraApiApplication.class, args);
    }

    @Bean
    public void initDatabaseUser() {
        ArrayList<UserModel> users = new ArrayList<>();
        users.add(new UserModel("Adam"));
        users.add(new UserModel("Bolton"));
        users.add(new UserModel("Chelsea"));
        users.add(new UserModel("Elsy"));
        users.add(new UserModel("Vincent"));
        users.add(new UserModel("Warden"));
        users.forEach(user -> userService.save(user));
    }

    @Bean
    public void initDatabaseBill() throws ParseException {

        ArrayList<BillsModel> bills = new ArrayList<>();
        SimpleDateFormat date = new SimpleDateFormat("dd-mm-yyyy");
        UserModel user = userService.findById(1);
        bills.add(new BillsModel(date.parse("01-01-2021"), 2000000, user));
        bills.add(new BillsModel(date.parse("02-01-2021"), 1000000, user));
        bills.add(new BillsModel(date.parse("03-01-2021"), 1000000, user));
        user = userService.findById(2);
        bills.add(new BillsModel(date.parse("01-01-2021"), 400000, user));
        bills.add(new BillsModel(date.parse("03-01-2021"), 1100000, user));
        bills.add(new BillsModel(date.parse("02-01-2021"), 500000, user));
        user = userService.findById(3);
		bills.add(new BillsModel(date.parse("02-01-2021"), 900000, user));
		bills.add(new BillsModel(date.parse("02-01-2021"), 59900, user));
		bills.add(new BillsModel(date.parse("03-01-2021"), 1100000, user));
		user = userService.findById(4);
		bills.add(new BillsModel(date.parse("02-01-2021"), 4000000, user));
		user = userService.findById(5);
		bills.add(new BillsModel(date.parse("03-01-2021"), 899999, user));
		user = userService.findById(6);
		bills.add(new BillsModel(date.parse("02-01-2021"), 5100000, user));
		bills.add(new BillsModel(date.parse("03-01-2021"), 1100000, user));
        bills.forEach(bill -> billService.save(bill));
    }
}
