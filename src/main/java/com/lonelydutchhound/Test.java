package com.lonelydutchhound;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
    static Logger logger = LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) {
        logger.info("Test");
        logger.debug("Test debug");
    }
}
