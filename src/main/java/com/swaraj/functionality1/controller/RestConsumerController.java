package com.swaraj.functionality1.controller;

import com.swaraj.functionality1.dto.UserResponse;
import com.swaraj.functionality1.service.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest-consumer")
@Slf4j
public class RestConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;

    @Autowired
    private WebClient webClient;

    /*
    * use resttemplate to call rest api
    * */
    @GetMapping("/template")
    public List<UserResponse> getDataUsingRestTemplate() {
        log.info("request to get url via rest template");
        List<UserResponse> forObject = restTemplate.getForObject("https://jsonplaceholder.typicode.com/users", List.class);
        return forObject;
    }

    /*
    * Declarative way of calling the api via feign
    * */
    @GetMapping("/feign-client")
    public List<UserResponse> getDataUsingFeignClient() {
        log.info("request to get url via feign client");
        List<UserResponse> forObject = userClient.getUsers();
        return forObject;
    }

    @GetMapping("/web-client")
    public List<UserResponse> getDataUsingWebClient() {
        log.info("request to get url via web client");

        Flux<UserResponse> userResponseFlux = webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(UserResponse.class);

        return userResponseFlux.collectList().block();
    }
}
