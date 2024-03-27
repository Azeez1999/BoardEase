package com.debug.backend.service;

import com.debug.backend.entity.Feedback;
import com.debug.backend.entity.Product;
import com.debug.backend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback getFeedbackById(int id) {
        return feedbackRepository.findUserID(id);
    }

    public List<Feedback> getFeedback() {
        return feedbackRepository.findAll();
    }

    public String updateFeedback(int id, Feedback updateFeedback) {
        if (feedbackRepository.existsById(id)) {
            Feedback existFeedback = feedbackRepository.findById(id).get();
            existFeedback.setFeedBack(updateFeedback.getFeedBack());
            feedbackRepository.save(existFeedback);
            return "Product Details updated";
        } else {
            return "Product with ID " + id + " does not exist";
        }
    }
}
