package com.clozingtag.clozingtag.auth.service.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Table
@Entity(name = "ct_users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity implements UserDetails {

  @Id
  @GeneratedValue( strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  @Column(unique = true)
  private String username;

  @NotBlank private String lastname;

  @NotBlank private String firstname;

  @NotBlank private String password;

  @Builder.Default private boolean enabled = true;

  @Builder.Default private boolean accountNonLocked = true;

  @Builder.Default private boolean accountNonExpired = true;

  @Builder.Default private boolean credentialsNonExpired = true;


  @ManyToMany(fetch = FetchType.EAGER)
  private Collection<RoleEntity> roles;

  @NotNull private LocalDateTime createdAt;

  @Transient private String name;

  public String getName() {
    return String.format("%s %s", getLastname(), getFirstname());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return getRoles().stream().map(roleEntity -> new SimpleGrantedAuthority(roleEntity.getName())).toList();
  }

}
