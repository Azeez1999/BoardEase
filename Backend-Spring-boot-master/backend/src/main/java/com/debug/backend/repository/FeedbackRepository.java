package com.debug.backend.repository;

import com.debug.backend.entity.Feedback;
import com.debug.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("SELECT u FROM Feedback u WHERE u.userID = :userID")
    Feedback findUserID(@Param("userID") int userID);
}
