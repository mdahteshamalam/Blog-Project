package com.blogapp111.repository;

import com.blogapp111.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existByEmail(String email);
    boolean existByUserName(String username);
}