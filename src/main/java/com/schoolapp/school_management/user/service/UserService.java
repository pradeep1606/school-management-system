package com.schoolapp.school_management.user.service;


import com.schoolapp.school_management.user.entity.User;
import org.springframework.data.domain.Page;
import com.schoolapp.school_management.user.dto.UserResponse;


public interface UserService {


    User createUser(User user);

    User getUserById(Long id);

    Page<UserResponse> getUsersBySchool(Long schoolId, int page, int size);
}