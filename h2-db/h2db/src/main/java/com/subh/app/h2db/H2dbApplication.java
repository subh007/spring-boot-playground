package com.subh.app.h2db;

import com.subh.app.h2db.configuration.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class H2dbApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2dbApplication.class, args);
	}

}
