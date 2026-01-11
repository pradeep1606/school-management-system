package com.schoolapp.school_management.user.controller;


import com.schoolapp.school_management.common.response.ApiResponse;
import com.schoolapp.school_management.role.entity.Role;
import com.schoolapp.school_management.school.entity.School;
import com.schoolapp.school_management.user.dto.UserCreateRequest;
import com.schoolapp.school_management.user.dto.UserResponse;
import com.schoolapp.school_management.user.entity.User;
import com.schoolapp.school_management.user.mapper.UserMapper;
import com.schoolapp.school_management.user.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserServiceImpl userService;


    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    // Create User
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(
            @Valid @RequestBody UserCreateRequest request) {

        School school = userService.getSchoolById(request.getSchoolId());
        Role role = userService.getRoleById(request.getRoleId());

        User user = UserMapper.toEntity(request, school, role);
        User saved = userService.createUser(user);

        UserResponse response = UserMapper.toResponse(saved);
        return new ResponseEntity<>(ApiResponse.success("User created successfully", response), HttpStatus.CREATED);
    }


    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponse>> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        UserResponse response = UserMapper.toResponse(user);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<ApiResponse<Page<UserResponse>>> getUsersBySchool(
            @PathVariable Long schoolId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<UserResponse> users = userService.getUsersBySchool(schoolId, page, size);
        return ResponseEntity.ok(ApiResponse.success(users));
    }

}