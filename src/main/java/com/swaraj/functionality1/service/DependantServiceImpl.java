package com.swaraj.functionality1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("dependantService")
public class DependantServiceImpl implements DependantService {

    private final Functionality1Service functionality1Service;

    @Autowired
    public DependantServiceImpl(@Qualifier("functionality1ServiceImpl") Functionality1Service functionality1Service) {
        this.functionality1Service = functionality1Service;
    }

    @Override
    public String performOperation(String name) {
        return "operation performed on " + name + " " + functionality1Service.displayServiceName("hola");
    }
}
