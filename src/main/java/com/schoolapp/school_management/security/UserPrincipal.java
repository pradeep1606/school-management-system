package com.schoolapp.school_management.security;

public class UserPrincipal {

    private final Long userId;
    private final String username;
    private final Long schoolId;
    private final String role;

    public UserPrincipal(Long userId, String username, Long schoolId, String role) {
        this.userId = userId;
        this.username = username;
        this.schoolId = schoolId;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public String getRole() {
        return role;
    }
}
