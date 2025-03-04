package com.clozingtag.clozingtag.auth.service.mapper;

import com.clozingtag.clozingtag.auth.service.dto.response.role.RoleResponse;
import com.clozingtag.clozingtag.auth.service.dto.response.user.UserResponse;
import com.clozingtag.clozingtag.auth.service.entity.RoleEntity;
import com.clozingtag.clozingtag.auth.service.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring", uses = RoleMapper.class)
public interface UserMapper {

    @Mapping(target = "roles", source = "roles")
    UserResponse createUserResponseFromUserEntity(UserEntity userEntity);

    Collection<RoleResponse> convertRoleEntityToRoleResponse(Collection<RoleEntity> roles);
}

