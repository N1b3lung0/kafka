package com.n1b3lung0.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void receiveMessage(ConsumerRecord<String, String> record) {
        logger.info(String.format("#### -> Consumed message -> %s", record.value()));
    }
}
