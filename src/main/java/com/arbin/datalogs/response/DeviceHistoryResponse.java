package com.arbin.datalogs.response;

import com.arbin.datalogs.model.DeviceChannelHistory;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceHistoryResponse {
    private String id;

    @JsonProperty("device_id")
    private String deviceId;

    @JsonProperty("channel_id")
    private Integer channelId;

    @JsonProperty("properties")
    private Map<String, Double> properties;


    @JsonProperty("created_date")
    private String createdDate;

    public DeviceHistoryResponse(DeviceChannelHistory dbItem) {
        this.id = dbItem.getId().toString();
        this.deviceId = dbItem.getDeviceId().toString();
        this.channelId = dbItem.getChannelId();
        this.properties = dbItem.getProperties();
        this.createdDate = dbItem.getCreatedDate().toString();
    }
}
