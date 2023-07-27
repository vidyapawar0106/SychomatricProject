package com.example.sychomatricProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sychomatricProject.entity.QuestionDetails;
import com.example.sychomatricProject.repository.QuestionDetailRepository;

@Service
public class QuestionDetailService {
	@Autowired
	QuestionDetailRepository repository;
	public QuestionDetails savedetails(QuestionDetails details)
	{
		return repository.save(details);
		
	}
	public List<QuestionDetails> storelist(List<QuestionDetails> details)
	{
		return repository.saveAll(details);
	}
	public List<QuestionDetails> getallvalue()
	{
		return repository.findAll();
	}

}
