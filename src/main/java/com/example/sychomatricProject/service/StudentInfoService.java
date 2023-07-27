package com.example.sychomatricProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sychomatricProject.Exception.ResourseNotFound;
import com.example.sychomatricProject.dto.QuestionDetaildto;
import com.example.sychomatricProject.dto.StudentInfoDto;
import com.example.sychomatricProject.entity.ImageData;
import com.example.sychomatricProject.entity.QuestionDetails;
import com.example.sychomatricProject.entity.StudentInfo;
import com.example.sychomatricProject.repository.QuestionDetailRepository;
import com.example.sychomatricProject.repository.StorageRepository;
import com.example.sychomatricProject.repository.StudentInfoRepository;

@Service
public class StudentInfoService {
	@Autowired
	StudentInfoRepository Studrepository;
	@Autowired
	QuestionDetailRepository questionRepository;
	@Autowired
	StorageRepository storagerepository;
	
	
    public StudentInfo saveStudentInfo(StudentInfoDto dto)
    {
    	StudentInfo info=new StudentInfo();
    	info.setName(dto.getName());
    	info.setAddress(dto.getAddress());
    	info.setEmail(dto.getEmail());
    	long img_id=dto.getImage_id();
    	ImageData data=storagerepository.findById(img_id).get();
    	info.setData(data);
    	
    	//System.out.println(dto.getDetails());
    	List<QuestionDetaildto> newdetail=dto.getDetails();
    	//List<QuestionDetaildto> newdetailsave=new ArrayList<>();
   
    	
    	
    	
    	
    	
    	//info.setDetails(list);
    	//info.setData(data);
    	info.setDetails(newdetail);
    	
    	StudentInfo newinfo=Studrepository.save(info);
    	return newinfo;
    }
    public StudentInfo findbyname(String name) throws ResourseNotFound
    {
    	return Studrepository.findByName(name).get();
    }
    public StudentInfo findbyid(long id) throws ResourseNotFound
    {
    	return Studrepository.findById(id).get();
    }
}
