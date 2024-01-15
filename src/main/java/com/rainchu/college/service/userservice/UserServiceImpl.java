package com.rainchu.college.service.userservice;

import com.rainchu.college.entity.User;
import com.rainchu.college.exception.NoResourceFoundException;
import com.rainchu.college.payloads.UserDto;
import com.rainchu.college.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(User userDto) {

        return this.userRepository.save(userDto);
    }

    @Override
    public User updateUser(User userDto, Integer id) throws NoResourceFoundException {

       User user= userRepository.findById(id).orElseThrow(()-> new NoResourceFoundException("No User Id Found"));

       user.setAbout(userDto.getAbout());
       user.setPassword(userDto.getPassword());
       user.setEmail(userDto.getEmail());
       user.setName(userDto.getName());

       userRepository.save(user);
        return user;
    }

    @Override
    public User getUserById(int id) throws NoResourceFoundException {


        return this.userRepository.findById(id).orElseThrow(()->new NoResourceFoundException("No User Id Found"));
    }

    @Override
    public List<User> getUser() {
        return new ArrayList<>(this.userRepository.findAll());
    }

    @Override
    public void deleteById(int id) throws NoResourceFoundException {
        User user = this.userRepository.findById(id).orElseThrow(() -> new NoResourceFoundException("No User Id Found of this Id"));
        this.userRepository.deleteById(id);
    }

    public User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setuId(user.getuId());
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(user.getPassword());

        return user;
    }

    public UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setuId(user.getuId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());

        return  userDto;
    }
}
