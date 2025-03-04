package com.clozingtag.clozingtag.auth.service.service;


import com.clozingtag.clozingtag.auth.service.dto.request.user.UserRequest;
import com.clozingtag.clozingtag.auth.service.dto.response.user.UserResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    UserResponse getUserDetail(Long id);

    UserResponse getUserDetails(String email);

    List<UserResponse> getAllUsers(Pageable pageable);
}
