package com.arbin.datalogs;

import com.arbin.datalogs.util.CassandraKeyspaceInitializer;
import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatalogsApplication {

	public static void main(String[] args) {
		try (CqlSession cqlSession = CqlSession.builder().build()) {
			CassandraKeyspaceInitializer.createKeyspace(cqlSession);
		}

		SpringApplication.run(DatalogsApplication.class, args);
	}

}
