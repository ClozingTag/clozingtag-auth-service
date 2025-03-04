package com.clozingtag.clozingtag.auth.service.impl;


import com.clozingtag.clozingtag.auth.service.dto.request.role.RoleRequest;
import com.clozingtag.clozingtag.auth.service.dto.response.role.RoleResponse;
import com.clozingtag.clozingtag.auth.service.entity.RoleEntity;
import com.clozingtag.clozingtag.auth.service.entity.UserEntity;
import com.clozingtag.clozingtag.auth.service.enums.RoleEnums;
import com.clozingtag.clozingtag.auth.service.mapper.RoleMapper;
import com.clozingtag.clozingtag.auth.service.repository.RoleRepository;
import com.clozingtag.clozingtag.auth.service.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Transactional
    @Override
    public RoleResponse createRole(RoleRequest request) {
        String roleName = request.getRole().getValue();
        return roleRepository.findByName(roleName)
                .or(() -> Optional.of(roleRepository.save(
                        RoleEntity.builder()
                                .name(roleName)
                                .description(request.getRole().name())
                                .build()
                )))
                .map(roleMapper::convertRoleEntityToRoleResponse)
                .orElseThrow(() -> new RuntimeException("Failed to create or retrieve role"));
    }

    @Override
    public List<RoleResponse> getRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::convertRoleEntityToRoleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<RoleEntity> buildUserRole(UserEntity userEntity, RoleEnums roleEnums) {
        Optional<RoleEntity> roleEntity = roleRepository.findByName(roleEnums.getValue());
        List<RoleEntity> roleEntityList = new ArrayList<>(userEntity.getRoles());
        roleEntity.ifPresent(roleEntityList::add);
        return roleEntityList;
    }

}
