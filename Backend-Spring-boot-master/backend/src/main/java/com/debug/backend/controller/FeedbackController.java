package com.debug.backend.controller;

import com.debug.backend.entity.Feedback;
import com.debug.backend.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/addFeedback")
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping("/feedbackById/{id}")
    public Feedback findProductById(@PathVariable int id) {
        return feedbackService.getFeedbackById(id);
    }

    @PutMapping("/updateFeedback/{id}")
    public String updateFeedback(@PathVariable int id, @RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(id, feedback);
    }

    @GetMapping("/feedbacks")
    public List<Feedback> findAllFeedback() {
        return feedbackService.getFeedback();
    }
}
