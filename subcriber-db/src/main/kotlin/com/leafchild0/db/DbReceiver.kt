package com.leafchild0.db

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.stereotype.Component

/**
 * @author victor
 * @date 10/29/18
 */
@Component
class DbReceiverKafka {

	@Autowired
	lateinit var repository: MessageRepository

	@KafkaListener(topics = ["spring-kafka"])
	fun onReceiving(message: String, @Header(KafkaHeaders.OFFSET) offset: Int?,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) partition: Int,
			@Header(KafkaHeaders.RECEIVED_TOPIC) topic: String) {

		println("Processing topic = $topic, partition = $partition, offset = $offset, message = $message")
		repository.save(Message(message))
	}

}

