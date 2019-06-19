package br.com.lms.salesengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SalesEngineConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesEngineConfigServerApplication.class, args);
	}

}