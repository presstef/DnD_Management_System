package fp.dndmanagementsystem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "campaigns.api")
public class CampaignApiConfig {
        private String baseUrl;

        public String getBaseUrl() {
            return baseUrl;
        }

        public CampaignApiConfig setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }
}
