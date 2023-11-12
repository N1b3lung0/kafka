package com.n1b3lung0.kafka.controller;

import com.n1b3lung0.kafka.producer.KafkaProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer producerService;

    public KafkaController(KafkaProducer producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/publish")
    public String sendMessage(@RequestParam("message") String message) {
        producerService.sendMessage("users", message);
        return "Message sent: " + message;
    }
}
