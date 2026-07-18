package com.github.victorMarchiDev.live_painel.controller;

import com.github.victorMarchiDev.live_painel.dto.QueueItemDTO;
import com.github.victorMarchiDev.live_painel.model.QueueItem;
import com.github.victorMarchiDev.live_painel.model.Status;
import com.github.victorMarchiDev.live_painel.service.QueueProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    private final QueueProducerService producerService;

    public QueueController(QueueProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public QueueItemDTO create(@RequestBody QueueItemDTO request) {

        QueueItem item = new QueueItem();
        item.setId(System.currentTimeMillis());
        item.setDescription(request.description());
        item.setStatus(Status.WAITING);

        producerService.publish(item);

        return new QueueItemDTO(
                item.getId(),
                item.getDescription(),
                item.getStatus()
        );
    }
}
