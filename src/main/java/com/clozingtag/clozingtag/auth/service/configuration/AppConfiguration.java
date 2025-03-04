package com.clozingtag.clozingtag.auth.service.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@ConfigurationProperties("auth")
@Data
public class AppConfiguration {

  private OauthClient oauth;
  private Organisation org;
  private SafeHavenCred safeHaven;
  private String msg;
  private String baseUrl;
  private String buildVersion;
  private String environment;
  private Long appAbuseCount;
  private JwtKeyStore jwt;
  private CloudinaryConfig cloudinaryConfig;
  private OrganisationMembers orgMembers;

  @Data
  public static class OauthClient {
    private String clientId;

    private String clientSecret;

    private RedirectUri redirectUri;
  }

  @Data
  public static class OrganisationMembers {
    private Integer standard;
    private Integer premium;
    private Integer payperuse;
    private Integer free;
  }

  @Data
  public static class RedirectUri {
    private String login;
  }

  @Data
  public static class Organisation {
    private String prodUrl;

    private String testUrl;

    private boolean isProd;

    private String env;
  }

  @Data
  public static class SafeHavenCred {
    private SafeHavenProd prod;

    private SafeHavenSandBox sandBox;

    private String bankCode;

    private String grantType;

    private String clientId;

    private String clientAssertionType;
  }

  @Data
  public static class SafeHavenProd {
    private String url;

    private String clientAssertion;

    private String debitAccount;
  }

  @Data
  public static class SafeHavenSandBox {
    private String url;

    private String clientAssertion;

    private String debitAccount;
  }

  @Data
  public static class JwtKeyStore {
    private JwtStoreKey key;

    private JwtStorePersistence persistence;
  }

  @Data
  public static class JwtStoreKey {
    private RSAPublicKey publicKey;

    private RSAPrivateKey privateKey;

    private String id;
  }

  @Data
  public static class JwtStorePersistence {
    private String password;

    private String salt;
  }

  @Data
  public static class CloudinaryConfig {
    private String cloudName;

    private String apiKey;

    private String apiSecret;

    private String noFileUrl;
  }
}
