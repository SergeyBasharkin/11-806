package ru.kpfu.itis.demo.blog.impl.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dummycreator.ClassBindings;
import org.dummycreator.DummyCreator;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kpfu.itis.demo.blog.api.dto.UserDTO;
import ru.kpfu.itis.demo.blog.impl.config.TestConfiguration;
import ru.kpfu.itis.demo.blog.impl.entity.User;
import ru.kpfu.itis.demo.blog.impl.jpa.UserRepository;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest
class UserServiceDBTest {

//    @Autowired
//    private UserServiceDB userServiceDB;

    private DummyCreator dummyCreator = new DummyCreator(ClassBindings.defaultBindings());

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void save() {
        UserDTO userDto = dummyCreator.create(UserDTO.class);
        userDto.setUsername("322");
        UserDetails userDetails = userServiceDB.loadUserByUsername("322");

        assertNull(userDetails);

        userServiceDB.save(userDto);

        userDetails = userServiceDB.loadUserByUsername("322");

        assertEquals(userDetails.getUsername(), userDto.getUsername());
    }


    private UserServiceDB userServiceDB;

    @Test
    void loadUserByUsername() {
        UserRepository userRepository = mock(UserRepository.class);

        when(userRepository.findByUsername(anyString())).thenReturn(dummyCreator.create(User.class));

        doNothing().when(userRepository).save(any());

        userServiceDB = new UserServiceDB(userRepository, new ModelMapper(), new BCryptPasswordEncoder());

        assertNotNull(userServiceDB.loadUserByUsername("322"));
    }

    @Test
    void testObjectMapper() throws JsonProcessingException {
        User user = dummyCreator.create(User.class);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        System.out.println(objectMapper.readValue(json, User.class));
    }
}