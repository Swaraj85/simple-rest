package com.swaraj.functionality1.config;

import com.swaraj.functionality1.service.SwagComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class Functionality1Config {
    public Functionality1Config() {
        log.info("Functionality1Config created");
    }

    //@Bean("swagComponentRequestScoped")
    @Bean
    @RequestScope
    public SwagComponent swagComponentRequestScoped() {
        SwagComponent swagComponent = new SwagComponent("request");
        return swagComponent;
    }

    @Bean
    @Scope("prototype")
    public SwagComponent swagPrototypeScope() {
        SwagComponent swagComponent = new SwagComponent("prototype");
        return swagComponent;
    }

    /*@Bean
    @SessionScope
    public SwagComponent swagComponentSessionScoped() {
        SwagComponent swagComponent = new SwagComponent();
        return swagComponent;
    }*/

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build();
    }

    @Bean
    //@Profile("stg")
    @ConditionalOnProperty(prefix = "app.custom", name = "name", havingValue = "hammer")
    public Map<String, String> mySwagMapStg() {
        log.info("bean mySwagMap loaded in hammer ");
        return new HashMap<>();
    }

    @Bean
    @Profile("prd")
    public Map<String, String> mySwagMapPrd() {
        log.info("bean mySwagMap loaded in prd environment");
        return new HashMap<>();
    }
}
