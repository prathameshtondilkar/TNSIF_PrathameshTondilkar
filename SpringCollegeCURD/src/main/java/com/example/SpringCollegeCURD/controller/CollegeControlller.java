package com.example.SpringCollegeCURD.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringCollegeCURD.entity.College;
import com.example.SpringCollegeCURD.service.CollegeService;


@RestController
public class CollegeControlller {

	@Autowired
	public CollegeService service;
	
	@PostMapping("/addCollege")
	public College regCollege(@RequestBody College col) {
		return service.addCollege(col);
	}
	
	@GetMapping("/getCollege")
	public List<College> getCollege() {
		return service.getCollege();
	}
	
	@DeleteMapping("/deleteCollege/{id}")
	public void deleteCollege(@PathVariable Long id) {
		service.deleteCollege(id);
	}
	
	@PutMapping("/updateCollege/{id}")
	public College updateCollege(@PathVariable Long id,@RequestBody College col) {
		return service.updateCollege(id,col);
	}
}
