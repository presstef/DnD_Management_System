package fp.dndmanagementsystem.config;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "dnd5eapi.api")
public class ApiConfig {
    private String url;

    public String getUrl() {
        return url = "https://www.dnd5eapi.co/api/";
    }

    public ApiConfig setUrl(String url) {
        this.url = "https://www.dnd5eapi.co/api/";
        return this;
    }

    @PostConstruct
    public void checkConfiguration() {
        verifyNotNullOrEmpty("url", url);
    }


    private static void verifyNotNullOrEmpty(String name, String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Property " + name + " cannot be empty.");
        }
    }
}
