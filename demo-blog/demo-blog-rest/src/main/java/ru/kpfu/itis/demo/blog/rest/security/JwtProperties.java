package ru.kpfu.itis.demo.blog.rest.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "blog.rest.jwt")
public class JwtProperties {
    private String secret;
    private Long validity;
}
