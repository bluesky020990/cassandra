package com.arbin.datalogs.model;

import com.arbin.datalogs.request.LogDataRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.Map;
import java.util.UUID;

@Table("device_channel_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceChannelHistory {
    @Id
    @PrimaryKey
    private UUID id;

//    @PrimaryKeyColumn(name = "device_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @Column("device_id")
    private UUID deviceId;

    @Column("channel_id")
    private Integer channelId;

    @Column("properties")
    private Map<String, Double> properties;

    @Column("created_date")
    private Timestamp createdDate;

    public DeviceChannelHistory(LogDataRequest data) {
        this.id = UUID.randomUUID();
        this.deviceId = UUID.fromString(data.getDeviceId());
        this.channelId = data.getChannelId();
        this.properties = data.getProperties();
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }

    //https://www.baeldung.com/cassandra-data-types
}
