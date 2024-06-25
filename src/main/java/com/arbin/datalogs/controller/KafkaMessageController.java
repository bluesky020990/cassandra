package com.arbin.datalogs.controller;

import com.arbin.datalogs.model.KafkaMessage;
import com.arbin.datalogs.repository.KafkaMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class KafkaMessageController {

    @Autowired
    private KafkaMessageRepository kafkaMessageRepository;

    @GetMapping
    public Iterable<KafkaMessage> getMessages() {
        return kafkaMessageRepository.findAll();
    }
}
