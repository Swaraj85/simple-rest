package com.swaraj;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class SimpleAppTest {

    @Test
    void basic_test() {
        log.info("executing tests");
        log.info("executing more tests")
        assertEquals(true, true);
    }
}