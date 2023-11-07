package com.prashanth.model.apppropertiesconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfigValues {
    private String clientId;
    private String clientSecret;
}
