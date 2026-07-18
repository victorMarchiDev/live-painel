package com.github.victorMarchiDev.live_painel.service;

import com.github.victorMarchiDev.live_painel.config.KafkaConfig;
import com.github.victorMarchiDev.live_painel.model.QueueItem;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class QueueConsumerService {

    @KafkaListener(
            topics = KafkaConfig.PEDIDOS_TOPIC,
            groupId = "queue-consumer-group"
    )
    public void consume(QueueItem item){
        System.out.println("Mensagem recebida: " + item);
    }
}
