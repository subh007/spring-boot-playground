package com.subh.camunda.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/process")
public class RestController {

    @Autowired
    RuntimeService runtimeService;

    @GetMapping(value = "/{name}")
    public ResponseEntity<String> runProcess(@PathVariable("name") String name) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("test", "test");
        runtimeService.startProcessInstanceByKey("loanApproval", map);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
