package com.utilities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UtilityClass {
    public UtilityClass() {
        log.info("UtilityClass object created...");
    }
}
