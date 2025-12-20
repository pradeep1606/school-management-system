package com.schoolapp.school_management.school.controller;


import com.schoolapp.school_management.school.entity.School;
import com.schoolapp.school_management.school.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

// Create School
    @PostMapping
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        School createdSchool = schoolService.createSchool(school);
        return new ResponseEntity<>(createdSchool, HttpStatus.CREATED);
    }

// Get School By id
    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        School school = schoolService.getSchoolById(id);
        return ResponseEntity.ok(school);
    }


// Get School By school Code
    @GetMapping("/code/{code}")
    public ResponseEntity<School> getSchoolByCode(@PathVariable String code) {
        School school = schoolService.getSchoolByCode(code);
        return ResponseEntity.ok(school);
    }
}