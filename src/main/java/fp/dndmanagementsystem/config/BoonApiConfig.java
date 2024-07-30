package fp.dndmanagementsystem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "boons.api")
public class BoonApiConfig {
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public BoonApiConfig setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
