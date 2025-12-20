package com.schoolapp.school_management.school.service.impl;


import com.schoolapp.school_management.school.entity.School;
import com.schoolapp.school_management.school.repository.SchoolRepository;
import com.schoolapp.school_management.school.service.SchoolService;
import org.springframework.stereotype.Service;


@Service
public class SchoolServiceImpl implements SchoolService {


    private final SchoolRepository schoolRepository;


    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }


    @Override
    public School createSchool(School school) {


// Set status Active by default if it is null
        if (school.getStatus() == null) {
            school.setStatus("ACTIVE");
        }


// Business rule: check code already exits ? (school code must be unique)
        schoolRepository.findByCode(school.getCode())
                .ifPresent(existing -> {
                    throw new IllegalArgumentException("School code already exists");
                });


        return schoolRepository.save(school);
    }


    @Override
    public School getSchoolById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("School not found"));
    }


    @Override
    public School getSchoolByCode(String code) {
        return schoolRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("School not found"));
    }
}