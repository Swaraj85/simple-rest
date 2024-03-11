package com.swaraj;

import com.swaraj.functionality1.service.BeanScopeComponent;
import com.swaraj.functionality1.service.Functionality1Service;
import com.swaraj.functionality1.service.SwagComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages = {"com.utilities", "com.swaraj"})
@EnableFeignClients
//@SpringBootApplication
@Slf4j
public class SimpleApp implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        log.info("PostConstruct executed....");
    }

    public static void main(String[] args) {
        log.info("main method executed..");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SimpleApp.class, args);
        log.info("spring boot run method executed..");

        Functionality1Service functionality1Service2 = applicationContext.getBean("functionality1ServiceImpl",
                Functionality1Service.class);

        log.info(functionality1Service2.displayServiceName("main"));
    }

    @Override
    public void run(String... args) throws Exception {
        // this will also be called
        log.info("commandlinerunner run executed");

        BeanScopeComponent bean = applicationContext.getBean(BeanScopeComponent.class);
        BeanScopeComponent bean2 = applicationContext.getBean(BeanScopeComponent.class);
        BeanScopeComponent bean3 = applicationContext.getBean(BeanScopeComponent.class);
        BeanScopeComponent bean4 = applicationContext.getBean(BeanScopeComponent.class);

        log.info("commandlinerunner run completed");
    }
}