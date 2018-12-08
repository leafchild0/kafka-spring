package com.leafchild0.vaadinkafka

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Subscriber with Vaadin inside which will simply display new messages
 */
@SpringBootApplication
class SubscriberWebApplication {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {

			SpringApplication.run(SubscriberWebApplication::class.java, *args)
		}
	}
}
