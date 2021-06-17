package com.project.goHealthy.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("com.project.goHealthy.entity")
@EnableJpaRepositories("com.project.goHealthy.repository")
@ComponentScan("com.project.goHealthy")
@Import({SecurityConfig.class})
public class AppConfig {
}
