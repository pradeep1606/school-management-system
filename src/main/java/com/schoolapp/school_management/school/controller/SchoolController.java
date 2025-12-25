package com.schoolapp.school_management.school.controller;


import com.schoolapp.school_management.school.dto.SchoolCreateRequest;
import com.schoolapp.school_management.school.dto.SchoolResponse;
import com.schoolapp.school_management.school.entity.School;
import com.schoolapp.school_management.school.service.SchoolService;
import jakarta.validation.Valid;
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
public ResponseEntity<SchoolResponse> createSchool(@Valid @RequestBody SchoolCreateRequest request) {
    School school = new School();
    school.setName(request.getName());
    school.setCode(request.getCode());
    school.setAddress(request.getAddress());
    school.setPhoneNumber(request.getPhoneNumber());
    school.setEmail(request.getEmail());
    school.setEstablishedYear(request.getEstablishedYear());

    School saved = schoolService.createSchool(school);

    SchoolResponse response = new SchoolResponse();
    response.setId(saved.getId());
    response.setName(saved.getName());
    response.setCode(saved.getCode());
    response.setAddress(saved.getAddress());
    response.setPhoneNumber(saved.getPhoneNumber());
    response.setEmail(saved.getEmail());
    response.setEstablishedYear(saved.getEstablishedYear());
    response.setStatus(saved.getStatus());
    response.setPlan(saved.getPlan());

    return new ResponseEntity<>(response, HttpStatus.CREATED);
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