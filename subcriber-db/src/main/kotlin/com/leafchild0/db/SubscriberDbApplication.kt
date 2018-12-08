package com.leafchild0.db

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

/**
 * App that actually send a message to a change and display it in
 * @author victor
 * @date 10/23/18
 */
@SpringBootApplication
@EnableJpaRepositories
class SubscriberDbApplication {

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {

			SpringApplication.run(SubscriberDbApplication::class.java, *args)
		}
	}

}
