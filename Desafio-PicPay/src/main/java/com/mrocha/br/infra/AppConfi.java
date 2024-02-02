package com.mrocha.br.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfi {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
