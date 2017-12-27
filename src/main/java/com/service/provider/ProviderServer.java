package com.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 服务提供者
 * 
 * @author clb
 * @version 1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages= {"com.service"},lazyInit=false)
public class ProviderServer {
	public static void main(String[] args) {
		SpringApplication.run(ProviderServer.class, args);
	}
}
