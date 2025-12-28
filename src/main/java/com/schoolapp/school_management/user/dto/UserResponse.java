package com.schoolapp.school_management.user.dto;


import java.time.LocalDateTime;

public class UserResponse {

    private Long id;
    private String userName;
    private String email;
    private String roleName;
    private Long schoolId;
    private String status;
    private LocalDateTime createdAt;


//  Getters & Setters

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


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


    public String getRoleName() {
        return roleName;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public Long getSchoolId() {
        return schoolId;
    }


    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}