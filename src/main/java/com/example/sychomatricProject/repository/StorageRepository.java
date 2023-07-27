package com.example.sychomatricProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sychomatricProject.entity.ImageData;

public interface StorageRepository extends JpaRepository<ImageData,Long> {
	
	Optional<ImageData> findByName(String filename);

}
