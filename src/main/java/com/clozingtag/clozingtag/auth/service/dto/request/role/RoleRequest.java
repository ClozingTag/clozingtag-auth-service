package com.clozingtag.clozingtag.auth.service.dto.request.role;


import com.clozingtag.clozingtag.auth.service.enums.RoleEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RoleRequest {
  private RoleEnums roleEnums;
}
