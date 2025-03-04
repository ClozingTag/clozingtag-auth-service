package com.clozingtag.clozingtag.auth.service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;


@Table
@Entity(name = "pf_roles")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleEntity implements GrantedAuthority {
  @Id
  @GeneratedValue( strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  private String name;

  private String description;

  @Override
  public String getAuthority() {
    return name;
  }
}
