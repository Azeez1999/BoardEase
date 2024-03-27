package com.debug.backend.repository;

import com.debug.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findUsername(@Param("email") String email);

    boolean existsByEmail(String email);

    int countByRole(String role);
}
