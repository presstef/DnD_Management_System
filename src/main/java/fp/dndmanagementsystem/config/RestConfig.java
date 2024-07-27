package fp.dndmanagementsystem.config;
import fp.dndmanagementsystem.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Configuration
public class RestConfig {
    @Bean
    public RestClient restClient() {
        return RestClient.create();
    }
}
