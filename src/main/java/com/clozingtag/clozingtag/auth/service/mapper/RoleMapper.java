package com.clozingtag.clozingtag.auth.service.mapper;

import com.clozingtag.clozingtag.auth.service.dto.response.role.RoleResponse;
import com.clozingtag.clozingtag.auth.service.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleResponse convertRoleEntityToRoleResponse(RoleEntity role);

//    @Named("mapRolesToRoleResponse") // Ensure this matches exactly with UserMapper reference
//    default Collection<RoleResponse> mapRolesToRoleResponse(Collection<RoleEntity> roles) {
//        return roles == null ? Collections.emptyList() :
//                roles.stream().map(this::convertRoleEntityToRoleResponse).collect(Collectors.toList());
//    }
}

