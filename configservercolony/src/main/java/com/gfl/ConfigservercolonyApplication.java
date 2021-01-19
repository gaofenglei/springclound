package com.gfl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigservercolonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigservercolonyApplication.class, args);
	}

}
