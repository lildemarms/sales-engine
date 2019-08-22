package br.com.lms.salesengine.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableHystrix
@EnableDiscoveryClient
public class SalesEngineZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesEngineZuulServerApplication.class, args);
	}
}
