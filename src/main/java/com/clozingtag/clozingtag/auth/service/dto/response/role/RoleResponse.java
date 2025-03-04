package com.clozingtag.clozingtag.auth.service.dto.response.role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleResponse {
    private String id;
    private String name;
    private String description;

}
