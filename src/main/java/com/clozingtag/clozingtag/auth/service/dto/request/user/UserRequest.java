package com.clozingtag.clozingtag.auth.service.dto.request.user;

import com.clozingtag.clozingtag.auth.service.enums.RoleEnums;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {

  @NotBlank private String lastname;

  @NotBlank private String firstname;

  @NotBlank private String email;

  @NotBlank private String password;

  @JsonIgnore private RoleEnums role;

}
