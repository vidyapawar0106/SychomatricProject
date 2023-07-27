package com.example.sychomatricProject.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.sychomatricProject.dto.StudentInfoDto;
import com.example.sychomatricProject.entity.ImageData;
import com.example.sychomatricProject.entity.QuestionDetails;
import com.example.sychomatricProject.entity.StudentInfo;
import com.example.sychomatricProject.repository.QuestionDetailRepository;
import com.example.sychomatricProject.repository.StorageRepository;
import com.example.sychomatricProject.service.QuestionDetailService;
import com.example.sychomatricProject.service.StorageService;
import com.example.sychomatricProject.service.StudentInfoService;

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {
	
	@Autowired
	StorageService service;
	@Autowired
	QuestionDetailService questionService; 
	@Autowired
	StudentInfoService studservice;
	

   @PostMapping("/save")
   public QuestionDetails saveQuestion(@RequestBody QuestionDetails details)
   { 
	  QuestionDetails questiondetails=questionService.savedetails(details);
	  return questiondetails;
   }
   @PostMapping("/savefile")
   public ResponseEntity<?> saveimage(@RequestParam("image") MultipartFile file) throws IOException 
   {
	   ImageData data=service.uploadImage(file);
	   return new ResponseEntity<>(data,HttpStatus.OK);
	   
   }
   @PostMapping("/savelist")
   public ResponseEntity<?> storeQuestionlist(@RequestBody List<QuestionDetails> details)
   {
	   List<QuestionDetails> queationdetails=questionService.storelist(details);
	   return new ResponseEntity<>(queationdetails,HttpStatus.OK);
   }
   @PostMapping("/studentDetail")
   public ResponseEntity<?> savestudentAnswer(@RequestBody StudentInfoDto studdto)
   {
	   StudentInfo info=studservice.saveStudentInfo(studdto);
	   
	   return new ResponseEntity<>(info,HttpStatus.OK);
   }
   @GetMapping("/getstudname/{name}") 
   public ResponseEntity<?> getstuddetailname(@PathVariable String name)
   {
	   StudentInfo info=studservice.findbyname(name);
	   return new ResponseEntity<>(info,HttpStatus.OK);
	   
   }
   @GetMapping("/getstudbyid/{id}")
   public ResponseEntity<?> getstudbyid(@PathVariable long id)
   {
	   StudentInfo info=studservice.findbyid(id);
	   return new ResponseEntity<>(info,HttpStatus.OK);
   }
   @GetMapping("/getAllQuestions")
   public ResponseEntity<?> getquestions()
   {
	   List<QuestionDetails> list=questionService.getallvalue();
	   return new ResponseEntity<>(list,HttpStatus.OK);
   }

}
