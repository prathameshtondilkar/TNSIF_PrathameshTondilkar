package com.example.SpringCollegeCURD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringCollegeCURD.entity.College;

public interface CollegeRepo extends JpaRepository<College,Long> {

}
