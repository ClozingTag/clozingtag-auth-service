package com.clozingtag.clozingtag.auth.service.mapper;

import com.clozingtag.clozingtag.auth.service.dto.request.user.UserRequest;
import com.clozingtag.clozingtag.auth.service.dto.response.user.UserResponse;
import com.clozingtag.clozingtag.auth.service.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse createUserResponseFromUserEntity(UserEntity userEntity);

    UserEntity createUserEntityFromUserRequest(UserRequest userRequest);
}
