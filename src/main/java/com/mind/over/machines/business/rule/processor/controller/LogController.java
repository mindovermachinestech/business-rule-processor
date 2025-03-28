package com.mind.over.machines.business.rule.processor.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogController {

    @GetMapping("/generate-log")
    public String generateCustomLog(@RequestParam String message) {
        log.info("Custom log message: {}", message);
        return "Log generated!";
    }
}