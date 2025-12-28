package com.schoolapp.school_management.user.service.impl;

import com.schoolapp.school_management.role.entity.Role;
import com.schoolapp.school_management.role.repository.RoleRepository;
import com.schoolapp.school_management.school.entity.School;
import com.schoolapp.school_management.school.repository.SchoolRepository;
import com.schoolapp.school_management.user.dto.UserResponse;
import com.schoolapp.school_management.user.entity.User;
import com.schoolapp.school_management.user.mapper.UserMapper;
import com.schoolapp.school_management.user.repository.UserRepository;
import com.schoolapp.school_management.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           SchoolRepository schoolRepository,
                           RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


//    Create User
    @Override
    public User createUser(User request) {
        //  Validate School
        School school = schoolRepository.findById(request.getSchool().getId())
                .orElseThrow(() -> new IllegalArgumentException("School not found"));

        //   Validate Role
        Role role = roleRepository.findById(request.getRole().getId())
                .orElseThrow(() -> new IllegalArgumentException("Role not found"));

        User user = new User();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // password encrypt
        user.setStatus("ACTIVE");

        user.setSchool(school);
        user.setRole(role);

        return userRepository.save(user);

    }


//    Get User by Id
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }


//    Get School by school id
    public School getSchoolById(Long schoolId) {
        return schoolRepository.findById(schoolId)
                .orElseThrow(() -> new IllegalArgumentException("School not found with id: " + schoolId));
    }


//    Get role by role id
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Role not found with id: " + roleId));
    }


//    Get Users By School id with pagination
    @Override
    public Page<UserResponse> getUsersBySchool(Long schoolId, int page, int size) {

        //  Validate school exists
        schoolRepository.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School not found"));

        PageRequest pageable = PageRequest.of(page, size);

        Page<User> usersPage = userRepository.findBySchoolId(schoolId, pageable);

        //  Map entity → DTO
        return usersPage.map(UserMapper::toResponse);
    }
}