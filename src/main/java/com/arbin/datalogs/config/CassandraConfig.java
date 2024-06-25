package com.arbin.datalogs.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class CassandraConfig {

    @Autowired
    private CqlSession cqlSession;

    @PostConstruct
    private void createKeyspace() {
        String keyspaceName = "test";
        String replicationStrategy = "SimpleStrategy";
        int replicationFactor = 1;

        // Create keyspace if it doesn't exist
        cqlSession.execute(String.format(
                "CREATE KEYSPACE IF NOT EXISTS %s WITH replication = {'class': '%s', 'replication_factor': %d}",
                keyspaceName, replicationStrategy, replicationFactor));


    }
}

// not working
