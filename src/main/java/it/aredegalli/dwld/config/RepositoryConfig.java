package it.aredegalli.dwld.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "it.aredegalli.dwld.repository")
public class RepositoryConfig {
}
