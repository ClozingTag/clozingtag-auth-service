package com.clozingtag.clozingtag.auth.service.mapper;

import com.clozingtag.clozingtag.auth.service.dto.response.role.RoleResponse;
import com.clozingtag.clozingtag.auth.service.entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse convertToRoleResponse(RoleEntity role);
}
