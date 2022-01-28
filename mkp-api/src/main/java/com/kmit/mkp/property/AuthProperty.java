package com.kmit.mkp.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("auth")
@Getter
@Setter
public class AuthProperty {
    private String secretKey;
}
