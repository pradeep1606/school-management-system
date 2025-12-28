package com.schoolapp.school_management.school.mapper;


import com.schoolapp.school_management.school.dto.SchoolCreateRequest;
import com.schoolapp.school_management.school.dto.SchoolResponse;
import com.schoolapp.school_management.school.entity.School;


public class SchoolMapper {


    private SchoolMapper() {
        // prevent instantiation
    }



    //  DTO → Entity
    public static School toEntity(SchoolCreateRequest request) {
        School school = new School();
        school.setName(request.getName());
        school.setCode(request.getCode());
        school.setAddress(request.getAddress());
        school.setPhoneNumber(request.getPhoneNumber());
        school.setEmail(request.getEmail());
        school.setEstablishedYear(request.getEstablishedYear());
        return school;
    }


    //  Entity → DTO
    public static SchoolResponse toResponse(School school) {
        SchoolResponse response = new SchoolResponse();
        response.setId(school.getId());
        response.setName(school.getName());
        response.setCode(school.getCode());
        response.setAddress(school.getAddress());
        response.setPhoneNumber(school.getPhoneNumber());
        response.setEmail(school.getEmail());
        response.setEstablishedYear(school.getEstablishedYear());
        response.setStatus(school.getStatus());
        response.setPlan(school.getPlan());
        return response;
    }
}