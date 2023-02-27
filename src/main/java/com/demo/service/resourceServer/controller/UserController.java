package com.demo.service.resourceServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    Environment env;

    @GetMapping("/status")
    public ResponseEntity<String> getUserStatus() {
        return new ResponseEntity("Working on port: " + env.getProperty("local.server.port"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUserId(@PathVariable String id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
