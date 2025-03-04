package com.clozingtag.clozingtag.auth.service.repository;


import com.clozingtag.clozingtag.auth.service.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  Optional<UserEntity> findUserByUsername(String username);

}
