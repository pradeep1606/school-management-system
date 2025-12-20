package com.schoolapp.school_management.school.service;

import com.schoolapp.school_management.school.entity.School;

public interface SchoolService {

    School createSchool(School school);

    School getSchoolById(Long id);

    School getSchoolByCode(String code);


}