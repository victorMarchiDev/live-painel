package com.github.victorMarchiDev.live_painel.dto;

import com.github.victorMarchiDev.live_painel.model.Status;

public record QueueItemDTO(
        Long id,
        String description,
        Status status
) {
}
