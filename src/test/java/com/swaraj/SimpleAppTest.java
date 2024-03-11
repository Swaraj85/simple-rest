package com.swaraj;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SimpleAppTest {

    @Test
    void basic_test() {
        log.info("executing tests");
        assertEquals(true, true);
    }
}