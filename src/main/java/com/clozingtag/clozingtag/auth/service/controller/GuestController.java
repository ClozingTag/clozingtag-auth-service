package com.clozingtag.clozingtag.auth.service.controller;

import com.clozingtag.clozingtag.auth.service.dto.request.user.UserRequest;
import com.clozingtag.clozingtag.auth.service.dto.response.user.UserResponse;
import com.clozingtag.clozingtag.auth.service.enums.RoleEnums;
import com.clozingtag.clozingtag.auth.service.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/guests")
public class GuestController {

    private final UserService userService;

    public GuestController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @Operation(
            summary = "create user",
            description = "Returns user details",
            tags = {"Guest Access"})
    @PostMapping(path = "user")
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) {
        userRequest.setRole(RoleEnums.User);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest));
    }

    @Hidden
    @PostMapping(path = "admin")
    public ResponseEntity<UserResponse> createAdmin(@RequestBody @Valid UserRequest userRequest) {
        userRequest.setRole(RoleEnums.Admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequest));
    }

}
