package com.arbin.datalogs.controller;

import com.arbin.datalogs.model.KafkaMessage;
import com.arbin.datalogs.repository.KafkaMessageRepository;
import com.arbin.datalogs.response.DeviceHistoryResponse;
import com.arbin.datalogs.service.DeviceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/devices")
public class DeviceHistoryController {

    @Autowired
    private DeviceHistoryService deviceHistoryService;

    @GetMapping("/{device_id}/channel/{channel_id}")
    public Iterable<DeviceHistoryResponse> findByDeviceAndChannel(@PathVariable("device_id") String deviceId, @PathVariable("channel_id") Integer channelId) {
        return deviceHistoryService.findByDeviceAndChannel(deviceId, channelId);
    }
}
