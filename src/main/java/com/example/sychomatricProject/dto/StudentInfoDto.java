package com.example.sychomatricProject.dto;

import java.util.List;

import com.example.sychomatricProject.entity.QuestionDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentInfoDto {
	private String name;
	private String email;
	private long image_id;
	private String address;
	private List<QuestionDetaildto> details;

}
