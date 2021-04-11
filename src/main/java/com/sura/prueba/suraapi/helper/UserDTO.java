package com.sura.prueba.suraapi.helper;

import com.sura.prueba.suraapi.model.UserModel;

public class UserDTO {
    private int id;
    private String name;

    public UserDTO(UserModel userModel) {
        this.id = userModel.getId();
        this.name = userModel.getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
