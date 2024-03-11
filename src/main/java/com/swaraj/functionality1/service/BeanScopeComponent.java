package com.swaraj.functionality1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton") // default scope
@Scope("prototype")
@Slf4j
public class BeanScopeComponent {
    public BeanScopeComponent() {
        log.info("BeanScopeService() object created...");
    }
}
