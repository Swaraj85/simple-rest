package com.swaraj.functionality1.service;

import org.springframework.stereotype.Service;

@Service
public class Functionality1ServiceImpl implements Functionality1Service {

    @Override
    public String displayServiceName(String inputString) {
        return inputString + " Functionality1ServiceImpl processed";
    }
}
