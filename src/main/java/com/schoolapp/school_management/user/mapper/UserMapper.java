package com.schoolapp.school_management.user.mapper;


import com.schoolapp.school_management.user.dto.UserCreateRequest;
import com.schoolapp.school_management.user.dto.UserResponse;
import com.schoolapp.school_management.user.entity.User;
import com.schoolapp.school_management.school.entity.School;
import com.schoolapp.school_management.role.entity.Role;


public class UserMapper {

    private UserMapper() {}

//    DTO → Entity
public static User toEntity(UserCreateRequest request, School school, Role role) {

    User user = new User();
    user.setUserName(request.getUserName());
    user.setEmail(request.getEmail());
    user.setSchool(school);
    user.setRole(role);

    user.setPassword(request.getPassword());

    user.setStatus("ACTIVE");

    return user;
}



    //    Entity → DTO
    public static UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUserName(user.getUserName());
        response.setEmail(user.getEmail());
        response.setSchoolId(user.getSchool().getId());
        response.setRoleName(user.getRole().getName());
        response.setStatus(user.getStatus());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }
}