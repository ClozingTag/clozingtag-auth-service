package com.clozingtag.clozingtag.auth.service.service;

import com.clozingtag.clozingtag.auth.service.dto.request.role.RoleRequest;
import com.clozingtag.clozingtag.auth.service.dto.response.role.RoleResponse;
import com.clozingtag.clozingtag.auth.service.entity.RoleEntity;
import com.clozingtag.clozingtag.auth.service.entity.UserEntity;
import com.clozingtag.clozingtag.auth.service.enums.RoleEnums;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface RoleService {

  RoleResponse createRole(RoleRequest request);

  List<RoleResponse> getRoles();

  Collection<RoleEntity> buildUserRole(UserEntity userEntity, RoleEnums roleEnums);
}
