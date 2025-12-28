package com.schoolapp.school_management.user.dto;


import jakarta.validation.constraints.*;


public class UserCreateRequest {

    @NotNull(message = "School ID is required")
    private Long schoolId;

    @NotNull(message = "Role ID is required")
    private Long roleId;

    @NotBlank(message = "Username is required")
    private String userName;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private String email;


//  Getters & Setters

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public Long getSchoolId() {
        return schoolId;
    }


    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }


    public Long getRoleId() {
        return roleId;
    }


    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }


}