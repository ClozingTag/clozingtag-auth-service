package com.clozingtag.clozingtag.auth.service.impl;


import com.clozingtag.clozingtag.auth.service.dto.request.user.UserRequest;
import com.clozingtag.clozingtag.auth.service.dto.response.user.UserResponse;
import com.clozingtag.clozingtag.auth.service.entity.RoleEntity;
import com.clozingtag.clozingtag.auth.service.entity.UserEntity;
import com.clozingtag.clozingtag.auth.service.exception.RoleNotFoundException;
import com.clozingtag.clozingtag.auth.service.exception.UserNotCreatedException;
import com.clozingtag.clozingtag.auth.service.exception.UserNotFoundException;
import com.clozingtag.clozingtag.auth.service.mapper.UserMapper;
import com.clozingtag.clozingtag.auth.service.repository.RoleRepository;
import com.clozingtag.clozingtag.auth.service.repository.UserRepository;
import com.clozingtag.clozingtag.auth.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository,
            UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        Optional<RoleEntity> roleEntity = roleRepository.findByName(request.getRole().getValue());
        if (roleEntity.isEmpty()) {
            throw new RoleNotFoundException("Role not found");
        }
        UserEntity entity = createUserEntityFromUserRequest(request, roleEntity.get());
        entity.setRoles(Collections.singleton(roleEntity.get()));
        entity.setPassword(passwordEncoder.encode(request.getPassword()));
        return Optional.of(userRepository.save(entity))
                .map(userMapper::createUserResponseFromUserEntity)
                .orElseThrow(() -> new UserNotCreatedException("User not created"));
    }

    private UserEntity createUserEntityFromUserRequest(UserRequest request, RoleEntity roleEntity) {
        return UserEntity.builder()
                .username(request.getUsername())
                .lastname(request.getLastname())
                .firstname(request.getFirstname())
                .password(passwordEncoder.encode(request.getPassword()))
                .createdAt(LocalDateTime.now())
                .roles(Collections.singleton(roleEntity))
                .build();
    }

    @Override
    public UserResponse getUser(Long id) {
        return userRepository.findById(id)
                .map(userMapper::createUserResponseFromUserEntity)
                .orElseThrow(() -> new UserNotFoundException("User not created"));
    }

    @Override
    public UserResponse getUserDetails(String email) {
        return userRepository.findUserByUsername(email)
                .map(userMapper::createUserResponseFromUserEntity)
                .orElseThrow(() -> new UserNotFoundException("User not created"));
    }

    @Override
    public List<UserResponse> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).getContent().stream()
                .map(userMapper::createUserResponseFromUserEntity).collect(Collectors.toList());

    }

}
