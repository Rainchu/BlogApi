package com.rainchu.college.service.userservice;

import com.rainchu.college.entity.User;
import com.rainchu.college.exception.NoResourceFoundException;
import com.rainchu.college.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

     User createUser(User userDto);

    User updateUser(User userDto,Integer id) throws NoResourceFoundException;

    User getUserById(int id) throws NoResourceFoundException;

    List<User> getUser();

    void deleteById(int id) throws NoResourceFoundException;

}
