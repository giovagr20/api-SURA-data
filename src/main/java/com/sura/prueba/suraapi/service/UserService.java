package com.sura.prueba.suraapi.service;

import com.sura.prueba.suraapi.model.UserModel;
import com.sura.prueba.suraapi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        List<UserModel> users = new ArrayList<>();
        userRepository.findAll().forEach(obj -> users.add(obj));
        return users;
    }

    @Override
    public UserModel findById(int id) {
        Optional<UserModel> user = userRepository.findById(id);
        if(user.isPresent()) {
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
}
