package com.example.sychomatricProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sychomatricProject.entity.StudentInfo;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,Long> {
	
	Optional<StudentInfo> findByName(String name);

}
