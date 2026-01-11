package com.schoolapp.school_management.common.response;

import com.schoolapp.school_management.common.exception.ErrorCode;

import java.time.LocalDateTime;

public class ErrorResponse {

    private boolean success = false;
    private ErrorCode errorCode;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public boolean isSuccess() {
        return success;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
