package com.arbin.datalogs.repository;

import com.arbin.datalogs.model.DeviceChannelHistory;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeviceHistoryRepository extends CassandraRepository<DeviceChannelHistory, String> {
//    @Query("SELECT * FROM device_channel_history WHERE deviceId = :deviceId AND channelId = :channelId")
    List<DeviceChannelHistory> findDeviceChannelHistoriesByDeviceId(UUID deviceId);

    List<DeviceChannelHistory> findDeviceChannelHistoriesByDeviceIdAndChannelId(UUID deviceId, Integer channelId);
}
