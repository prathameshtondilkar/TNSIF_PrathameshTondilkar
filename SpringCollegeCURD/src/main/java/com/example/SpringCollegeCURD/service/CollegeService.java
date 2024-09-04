package com.example.SpringCollegeCURD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringCollegeCURD.entity.College;
import com.example.SpringCollegeCURD.repository.CollegeRepo;


@Service
public class CollegeService {

	@Autowired
	private CollegeRepo collegerepo;


	//Create
	
	public College addCollege(College col) {
		return collegerepo.save(col);
		
		//Returning the place because we are not writing the query, we are just using the reference variable.
	}
	
	//Read
	public List<College> getCollege() {
		return collegerepo.findAll();
	}
	
	//Update
	public College updateCollege(Long collegeid,  College college) {
		Long id = college.getId();
		College col= collegerepo.findById(id).get();
		col.setCollegeName(college.getCollegeName());
		col.setCollegeAdmin(college.getCollegeAdmin());
		col.setLocation(college.getLocation());
	
		
		return collegerepo.save(col);
	}
	
	
	
	//Delete
	public void deleteCollege(Long id) {
		collegerepo.deleteById(id);
	}

	
}
