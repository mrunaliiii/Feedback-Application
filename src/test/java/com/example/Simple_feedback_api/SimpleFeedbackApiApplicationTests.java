package com.example.Simple_feedback_api;

import com.example.Simple_feedback_api.model.Feedback;
import com.example.Simple_feedback_api.repository.FeedbackRepository;
import com.example.Simple_feedback_api.service.FeedbackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class SimpleFeedbackApiApplicationTests {
	@MockBean
	private FeedbackRepository repository;

	@Autowired
	private FeedbackService service;

	@Test
	void testSaveFeedback() {
		Feedback feedback = new Feedback();
		feedback.setName("John Doe");
		feedback.setEmail("john@example.com");
		feedback.setMessage("Great service, really appreciated!");

		Mockito.when(repository.save(feedback)).thenReturn(feedback);

		Feedback saved = service.saveFeedback(feedback);
		Assertions.assertEquals("John Doe", saved.getName());
	}



}
