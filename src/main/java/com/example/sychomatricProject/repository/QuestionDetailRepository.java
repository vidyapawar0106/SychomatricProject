package com.example.sychomatricProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sychomatricProject.entity.QuestionDetails;

public interface QuestionDetailRepository extends JpaRepository<QuestionDetails,Long> {

}
