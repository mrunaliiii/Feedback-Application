package com.example.Simple_feedback_api.service;


import com.example.Simple_feedback_api.model.Feedback;
import com.example.Simple_feedback_api.repository.FeedbackRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FeedbackServiceTest {

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private FeedbackService feedbackService;

    public FeedbackServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveFeedback() {
        Feedback input = new Feedback();
        input.setName("Test");
        input.setEmail("test@example.com");
        input.setMessage("Hello");

        Feedback saved = new Feedback();
        saved.setId(1L);
        saved.setName("Test");
        saved.setEmail("test@example.com");
        saved.setMessage("Hello");

        when(feedbackRepository.save(input)).thenReturn(saved);

        Feedback result = feedbackService.saveFeedback(input);

        assertEquals("Test", result.getName());
        verify(feedbackRepository, times(1)).save(input);
    }
}

