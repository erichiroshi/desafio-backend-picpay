package com.erichiroshi.picpay.service;

import org.springframework.stereotype.Service;

import com.erichiroshi.picpay.client.NotificationClient;
import com.erichiroshi.picpay.entity.Transfer;
import com.erichiroshi.picpay.service.exception.NotificationException;

import feign.FeignException.FeignServerException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationService {

    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer) {

        try {
            log.info("Sending notification...");
            notificationClient.sendNotification(transfer);
        } catch (FeignServerException e) {
            log.error("Error during send notification: , status code is not OK. \n{}", e.getMessage());
            throw new NotificationException("Error during send notification");
        }
    }
}