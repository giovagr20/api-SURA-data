package com.sura.prueba.suraapi;

import com.sura.prueba.suraapi.model.UserModel;
import com.sura.prueba.suraapi.service.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SuraApiApplicationTests {

    @Autowired
    IUserService userService;
    @MockBean
    MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void validateIfExistCreation() {
        String text = "Juan";

        Optional<UserModel> user = Optional.ofNullable(userService.findById(1));

        if (!user.isPresent()) {
            throw new RuntimeException("An error has ocurred");
        }

        Assert.hasText(user.get().getName(), text);

    }

    @Test
    void existUser() {

    }
}
