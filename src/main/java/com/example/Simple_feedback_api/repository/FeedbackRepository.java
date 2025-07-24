package com.example.Simple_feedback_api.repository;

import com.example.Simple_feedback_api.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    }

