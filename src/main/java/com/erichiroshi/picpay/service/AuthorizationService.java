package com.erichiroshi.picpay.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.erichiroshi.picpay.client.AuthorizationClient;
import com.erichiroshi.picpay.client.dto.AuthorizationResponse;
import com.erichiroshi.picpay.controller.dto.TransferDTO;

import feign.FeignException.FeignClientException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDTO transferDto) {

        try {
            ResponseEntity<AuthorizationResponse> resp = authorizationClient.isAuthorized();
            return resp.getBody().data().get("authorization");

        } catch (FeignClientException e) {
            log.error("Error during authorization check: {}", e.getMessage());
            return false;
        }
    }
}