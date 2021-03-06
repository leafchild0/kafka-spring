package com.leafchild0.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author victor
 * @date 2018-12-06
 */

@Configuration
public class KafkaProducerConfig {

	private static final String KAFKA_SERVER = "localhost:9092";
	private static final String KAFKA_TOPIC = "spring-kafka";

	@Bean
	public ProducerFactory<String, String> producerFactory() {

		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}

	private Map<String, Object> producerConfigs() {

		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_SERVER);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, "100000");

		return props;
	}

	@Bean
	public Serializer stringSerializer() {
		return new StringSerializer();
	}

	@Bean
	KafkaTemplate<String, String> producer(ProducerFactory<String, String> producerFactory) {

		KafkaTemplate<String, String> kafkaTemplate =  new KafkaTemplate<>(producerFactory);
		kafkaTemplate.setDefaultTopic(KAFKA_TOPIC);
		return kafkaTemplate;
	}
}
