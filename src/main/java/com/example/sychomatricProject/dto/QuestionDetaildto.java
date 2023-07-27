package com.example.sychomatricProject.dto;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class QuestionDetaildto {
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String option5;
	private String answer;

	
}
