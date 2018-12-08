package com.leafchild0.db

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import java.util.*

@Configuration
@EnableKafka
class KafkaListenerConfig {

	@Bean
	fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String> {
		val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
		factory.setConcurrency(1)
		factory.consumerFactory = consumerFactory()
		return factory
	}

	@Bean
	fun consumerFactory(): ConsumerFactory<String, String> {
		return DefaultKafkaConsumerFactory(consumerProps(), stringDeserializer(),
		stringDeserializer()) as ConsumerFactory<String, String>
	}

	@Bean
	fun consumerProps(): Map<String, Any> {
		val props = HashMap<String, Any>()
		props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = KAFKA_SERVER
		props[ConsumerConfig.GROUP_ID_CONFIG] = GROUP_ID
		props[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = true
		props[ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG] = "100"
		props[ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG] = "15000"

		return props
	}

	@Bean
	fun stringDeserializer(): Deserializer<*> {
		return StringDeserializer()
	}

	companion object {
		private const val KAFKA_SERVER = "localhost:9092"
		internal const val GROUP_ID = "spring-kafka"
	}
}
