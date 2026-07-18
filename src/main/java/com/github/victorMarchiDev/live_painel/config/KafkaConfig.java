package com.github.victorMarchiDev.live_painel.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    public static final String PEDIDOS_TOPIC = "fila-pedidos";

    @Bean
    public NewTopic filaTopic(){
        return TopicBuilder.name(PEDIDOS_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }

}
