package br.com.lms.salesengine.adminserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SalesEngineAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesEngineAdminServerApplication.class, args);
	}

}
