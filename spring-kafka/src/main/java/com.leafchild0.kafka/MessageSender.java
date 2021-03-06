package com.leafchild0.kafka;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

/**
 * @author victor
 * @date 2018-11-26
 */

@Component
public class MessageSender {

	@Autowired
	protected KafkaTemplate<String, String> producer;

	void sendMessage(String message) {

		try {

			SendResult<String, String> result = producer.sendDefault(message).get();
			RecordMetadata recordMetadata = result.getRecordMetadata();
			System.out.println(String.format("topic = %s, partition = %s, offset = %s, message = %s",
					recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), message));
		}
		catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
}
