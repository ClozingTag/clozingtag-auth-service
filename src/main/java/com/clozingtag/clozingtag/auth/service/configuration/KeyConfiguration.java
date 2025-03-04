package com.clozingtag.clozingtag.auth.service.configuration;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyConfiguration {

  private final AppConfiguration appConfiguration;

  public KeyConfiguration(AppConfiguration appConfiguration) {
    this.appConfiguration = appConfiguration;
  }

  @Bean
  JWKSource<SecurityContext> jwkSource() {
    var rsa =
        new RSAKey.Builder(appConfiguration.getJwt().getKey().getPublicKey())
            .privateKey(appConfiguration.getJwt().getKey().getPrivateKey())
            .keyID(appConfiguration.getJwt().getKey().getId())
            .build();
    var jwt = new JWKSet(rsa);
    return new ImmutableJWKSet<>(jwt);
  }
}
