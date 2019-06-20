package br.com.lms.salesengine.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SalesEngineEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesEngineEurekaServerApplication.class, args);
	}

}
