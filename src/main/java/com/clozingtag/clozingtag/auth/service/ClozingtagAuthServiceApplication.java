package com.clozingtag.clozingtag.auth.service;

import com.clozingtag.clozingtag.auth.service.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
@EnableConfigurationProperties(value = AppConfiguration.class)
public class ClozingtagAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClozingtagAuthServiceApplication.class, args);
	}

}
