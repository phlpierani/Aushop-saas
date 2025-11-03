package com.pierani.saaid.Aushop_saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AushopSaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AushopSaasApplication.class, args);
	}

}
