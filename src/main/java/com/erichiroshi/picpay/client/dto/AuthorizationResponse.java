package com.erichiroshi.picpay.client.dto;

import java.util.Map;

public record AuthorizationResponse(
        String status,
        Map<String, Boolean> data) {
}