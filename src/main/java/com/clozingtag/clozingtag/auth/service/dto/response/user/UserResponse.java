package com.clozingtag.clozingtag.auth.service.dto.response.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

  private Long id;

  private String name;

  private String email;

  private String lastname;

  private String firstname;

  private Set<String> roles;

  private LocalDateTime createdAt;
}
