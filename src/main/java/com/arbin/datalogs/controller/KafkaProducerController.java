package com.arbin.datalogs.controller;

import com.arbin.datalogs.request.LogDataRequest;
import com.arbin.datalogs.service.DeviceHistoryService;
import com.arbin.datalogs.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaProducerService producerService;

    @Autowired
    private DeviceHistoryService deviceHistoryService;

    @GetMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return "Message published successfully";
    }

    @GetMapping("/generate")
    public String generateHistory() {
        LogDataRequest request = LogDataRequest.random("ed0d872f-10c7-4d51-89cb-19566ad436fb", 1);
        LogDataRequest request2 = LogDataRequest.random("ed0d872f-10c7-4d51-89cb-19566ad436fb", 2);
        LogDataRequest request3 = LogDataRequest.random("ed0d872f-10c7-4d51-89cb-19566ad436fb", 3);
        LogDataRequest request4 = LogDataRequest.random("ed0d872f-10c7-4d51-89cb-19566ad436fb", 3);
        LogDataRequest request5 = LogDataRequest.random("ed0d872f-10c7-4d51-89cb-19566ad436fb", 3);
        LogDataRequest request6 = LogDataRequest.random("ed0d872f-10c7-4d51-89cb-19566ad436fb", 3);

        deviceHistoryService.logData(request);
        deviceHistoryService.logData(request2);
        deviceHistoryService.logData(request3);
        deviceHistoryService.logData(request4);
        deviceHistoryService.logData(request5);
        deviceHistoryService.logData(request6);

        return "Message published successfully";
    }
}
