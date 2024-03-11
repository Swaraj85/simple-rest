package com.swaraj.functionality1.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SwagComponent {

    private final String scopeName;

    public SwagComponent(String scopeName) {
        this.scopeName = scopeName;
        log.info("SwagComponent() object created scope: " + scopeName);
    }

    public String getMessage() {
        return "hello " + scopeName;
    }
}
