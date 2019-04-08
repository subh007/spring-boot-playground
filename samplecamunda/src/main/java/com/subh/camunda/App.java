package com.subh.camunda;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableProcessApplication
public class App {

//    @Autowired
//    private RuntimeService runtimeService;

    public static void main(String... args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        System.out.println(run.getBeanDefinitionCount());
    }

//    @EventListener
//    private void processPostDeploy(PostDeployEvent event) {
//        runtimeService.startProcessInstanceByKey("loanApproval");
//    }
}