package com.sura.prueba.suraapi.helper.generic;

import com.sura.prueba.suraapi.helper.UserDTO;
import com.sura.prueba.suraapi.model.UserModel;

public class UserHelper {

    public static UserModel userFromDTO(UserDTO userDTO) {
        return new UserModel(userDTO.getId(), userDTO.getName());
    }
}
