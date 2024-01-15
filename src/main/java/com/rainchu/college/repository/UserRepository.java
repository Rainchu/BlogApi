package com.rainchu.college.repository;

import com.rainchu.college.entity.User;
import com.rainchu.college.payloads.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
