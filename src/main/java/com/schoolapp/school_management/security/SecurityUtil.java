package com.schoolapp.school_management.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    private static UserPrincipal getPrincipal() {
        Object principal = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        if (principal instanceof UserPrincipal userPrincipal) {
            return userPrincipal;
        }
        throw new IllegalStateException("Unauthorized access");
    }

    public static Long getCurrentUserId() {
        return getPrincipal().getUserId();
    }

    public static Long getCurrentSchoolId() {
        return getPrincipal().getSchoolId();
    }

    public static String getCurrentRole() {
        return getPrincipal().getRole();
    }
}
