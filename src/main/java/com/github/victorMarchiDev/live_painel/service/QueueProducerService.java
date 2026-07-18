package com.github.victorMarchiDev.live_painel.service;

import com.github.victorMarchiDev.live_painel.config.KafkaConfig;
import com.github.victorMarchiDev.live_painel.model.QueueItem;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueueProducerService {

    private final KafkaTemplate<String, QueueItem> kafkaTemplate;

    public QueueProducerService(KafkaTemplate<String, QueueItem> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(QueueItem item){
        kafkaTemplate.send(
                KafkaConfig.PEDIDOS_TOPIC,
                item.getId().toString(),
                item
        );
    }
}
