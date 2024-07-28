package fp.dndmanagementsystem.config;
import fp.dndmanagementsystem.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Configuration
public class RestConfig {
    @Bean("genericRestClient")
    public RestClient genericRestClient() {
        return RestClient.create();
    }

    @Bean("campaignsRestClient")
    public RestClient campaignsRestClient(CampaignApiConfig campaignApiConfig) {
        return RestClient
                .builder()
                .baseUrl(campaignApiConfig.getBaseUrl())
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
