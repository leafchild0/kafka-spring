package com.leafchild0.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Kafka publisher app
 *
 * @author victor
 * @date 2018-11-26
 */
@SpringBootApplication
public class PublisherApplication {

	public static void main(String[] args) {

		SpringApplication.run(PublisherApplication.class, args);
	}
}
