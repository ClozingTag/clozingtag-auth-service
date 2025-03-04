package com.clozingtag.clozingtag.auth.service.controller;


import com.clozingtag.clozingtag.auth.service.dto.request.role.RoleRequest;
import com.clozingtag.clozingtag.auth.service.dto.response.role.RoleResponse;
import com.clozingtag.clozingtag.auth.service.entity.RoleEntity;
import com.clozingtag.clozingtag.auth.service.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleController {

  private final RoleService roleService;

  public RoleController(RoleService roleService) {
    this.roleService = roleService;
  }

  @Operation(
      summary = "getRoles",
      description = "returns all roles",
      tags = {"Roles"})
  @GetMapping()
  public ResponseEntity<List<RoleResponse>> getRoles() {
    return ResponseEntity.ok(roleService.getRoles());
  }

  @Operation(
      summary = "createRole",
      description = "returns role",
      tags = {"Roles"})
  @PostMapping()
  public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(roleService.createRole(request));
  }
}
