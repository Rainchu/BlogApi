package com.rainchu.college.controller;

import com.rainchu.college.apiresponse.ApiResponse;
import com.rainchu.college.entity.User;
import com.rainchu.college.exception.NoResourceFoundException;

import com.rainchu.college.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/save")
    public ResponseEntity<String> saveUser(@RequestBody User userDto){

        if (userDto.getName().equals("")) {
            return ResponseEntity.ok("Please Provide the name");
        }

        if (userDto.getEmail().equals(""))
        {
            return ResponseEntity.ok("Please enter Email");
        }
        if (userDto.getPassword().equals("")){
           return ResponseEntity.ok("Please provide Password");
        }
        if (userDto.getAbout().equals("")){
           return ResponseEntity.ok("Please Provide About");
        }



        return ResponseEntity.ok("Added Success Fully");
    }

    @PutMapping("/update/{uId}")
    public ResponseEntity<String> update(@RequestBody User userDto, @PathVariable("uId") int uId) throws NoResourceFoundException {
        User updateUser = userService.updateUser(userDto, uId);

        return ResponseEntity.ok("updated");
    }

    @DeleteMapping("/delete/{uId}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("uId") int id) throws NoResourceFoundException {
        this.userService.deleteById(id);
        return new ResponseEntity<>(new ApiResponse("Deleted Successfully",true),HttpStatus.OK);
    }

    @GetMapping("/user/{uId}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("uId") int id) throws NoResourceFoundException {
        User user = this.userService.getUserById(id);
        return new  ResponseEntity<>(new ApiResponse("User Find Successfuully",true), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> user = this.userService.getUser();

        return  ResponseEntity.ok(user);
    }

}
