package com.clozingtag.clozingtag.auth.service.controller;


import com.clozingtag.clozingtag.auth.service.dto.response.user.UserResponse;
import com.clozingtag.clozingtag.auth.service.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Hidden
  @GetMapping("ping")
  public String ping(Authentication authentication) {
    return "Hello " + authentication.getName();
  }

  @Hidden
  @GetMapping("login")
  public String getLoginPage(Model model) {
    return "login";
  }

  @Operation(
      summary = "getUsers",
      description = "returns all users",
      tags = {"Users"})
  @GetMapping("")
  public ResponseEntity<List<UserResponse>> getUsers(
          @Parameter(description = "Page number (default: 0)") @RequestParam(defaultValue = "0") int page,
          @Parameter(description = "Page number (default: 0)") @RequestParam(defaultValue = "10") int size
  ) {
    return ResponseEntity.ok(userService.getUsers(PageRequest.of(page, size)));
  }

  @Operation(
      summary = "getUserDetails",
      description = "returns user details",
      tags = {"Users"})
  @GetMapping(value = "details")
  public ResponseEntity<UserResponse> getUserDetails(Authentication authentication) {
    return ResponseEntity.ok(userService.getUserDetails(authentication.getName()));
  }

  @Operation(
      summary = "getUser",
      description = "returns user details",
      tags = {"Users"})
  @GetMapping(value = "{id}")
  public ResponseEntity<UserResponse>  getUser(@PathVariable Long id) {
    return ResponseEntity.ok(userService.getUser(id));
  }

}
