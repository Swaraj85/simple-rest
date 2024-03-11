package com.swaraj.functionality1.service;

import com.swaraj.functionality1.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "${application.remote.url}", name = "user-client")
//@FeignClient(url = "https://jsonplaceholder.typicode.com", name = "user-client")
public interface UserClient {

    @GetMapping("/users")
    List<UserResponse> getUsers();
}
