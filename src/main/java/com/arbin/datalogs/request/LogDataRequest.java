package com.arbin.datalogs.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogDataRequest {
    private String deviceId;
    private Integer channelId;
    private HashMap<String, Double> properties;

    public static LogDataRequest random(String deviceId, Integer channelId){
        LogDataRequest response = new LogDataRequest();

        response.setChannelId(channelId);
        response.setDeviceId(deviceId);

        HashMap<String, Double> properties = new HashMap<>();
        properties.put("property_1", Math.random());
        properties.put("property_2", Math.random());
        properties.put("property_3", Math.random());
        properties.put("property_4", Math.random());
        properties.put("property_5", Math.random());
        properties.put("property_6", Math.random());

        response.setProperties(properties);

        return response;
    }
}
