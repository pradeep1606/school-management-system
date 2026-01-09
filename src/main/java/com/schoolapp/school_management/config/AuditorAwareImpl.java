package com.schoolapp.school_management.config;

import com.schoolapp.school_management.security.SecurityUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorProvider")
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        try {
            return Optional.of(SecurityUtil.getCurrentUserId());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
