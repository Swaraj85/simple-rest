package com.swaraj.functionality1.controller;

import com.swaraj.functionality1.service.BeanScopeComponent;
import com.swaraj.functionality1.service.DependantService;
import com.swaraj.functionality1.service.Functionality1Service;
import com.swaraj.functionality1.service.SwagComponent;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/functionality1")
@Slf4j
public class Functionality1Controller {

    private final Functionality1Service functionality1Service;
    private final DependantService dependantService;

    //@Autowired @Qualifier("swagPrototypeScope") private SwagComponent swagComponent;
    @Autowired @Qualifier("swagComponentRequestScoped") private SwagComponent swagComponent;

    @Value("${application.discount.price}")
    private int discountPrice;

    @Autowired
    public Functionality1Controller(@Qualifier("functionality1ServiceImpl") Functionality1Service functionality1Service,
                                    DependantService dependantService) {
        this.functionality1Service = functionality1Service;
        this.dependantService = dependantService;
    }

    @GetMapping("/index")
    @Operation(description = "calls the dependant service and appends some message")
    public String index() {
        String s = dependantService.performOperation(swagComponent.getMessage());
        return functionality1Service.displayServiceName("holla" + " discount price: "
                + discountPrice +
                " scope msg: " + s);
    }

    @GetMapping(value = "/header")
    @ResponseStatus(HttpStatus.OK)
    @Hidden
    public String getHeaderFromRequest(@RequestHeader("api-key") String apiKey) {
        return "header is: " + apiKey;
    }

    @GetMapping("/map")
    public Map<String, String> mapFunction() {
        Map<String, String> result = new HashMap<>();
        result.put("key1", "value1");
        result.put("key2", "value2");
        return result;
    }
}
