package com.schoolapp.school_management.school.dto;

import jakarta.validation.constraints.*;


public class SchoolCreateRequest {

    @NotBlank(message = "School name is required")
    @Size(max = 150)
    private String name;
    @NotBlank(message = "School code is required")
    @Size(max = 50)
    private String code;

    @Size(max = 255)
    private String address;

    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;

    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 1950, message = "Established year must be valid")
    @Max(value = 2050, message = "Established year must be valid")
    private Integer establishedYear;


    //Getter & Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(Integer establishedYear) {
        this.establishedYear = establishedYear;
    }
}