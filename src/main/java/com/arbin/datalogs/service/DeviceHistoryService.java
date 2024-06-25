package com.arbin.datalogs.service;


import com.arbin.datalogs.model.DeviceChannelHistory;
import com.arbin.datalogs.repository.DeviceHistoryRepository;
import com.arbin.datalogs.request.LogDataRequest;
import com.arbin.datalogs.response.DeviceHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeviceHistoryService {
    @Autowired
    private DeviceHistoryRepository deviceHistoryRepository;

    public void logData(LogDataRequest request) {
        DeviceChannelHistory deviceId = new DeviceChannelHistory(request);
        this.deviceHistoryRepository.save(deviceId);
    }

    public List<DeviceHistoryResponse> findByDeviceAndChannel(String deviceId, Integer channelId) {
        List<DeviceChannelHistory> histories = this.deviceHistoryRepository.findDeviceChannelHistoriesByDeviceId(UUID.fromString(deviceId));

//        List<DeviceChannelHistory> histories2 = this.deviceHistoryRepository.findByDeviceId(deviceId);
//
        List<DeviceChannelHistory> histories3 = this.deviceHistoryRepository.findDeviceChannelHistoriesByDeviceIdAndChannelId(UUID.fromString(deviceId), channelId);

        return histories.stream().map(DeviceHistoryResponse::new).collect(Collectors.toList());
    }
}
