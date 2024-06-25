package com.arbin.datalogs.repository;

import com.arbin.datalogs.model.KafkaMessage;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaMessageRepository extends CassandraRepository<KafkaMessage, String> {
}
