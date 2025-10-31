package com.erichiroshi.picpay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.picpay.controller.dto.TransferDTO;
import com.erichiroshi.picpay.entity.Transfer;
import com.erichiroshi.picpay.service.TransferService;

import jakarta.validation.Valid;

@RestController
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDTO dto) {

        Transfer resp = transferService.transfer(dto);

        return ResponseEntity.ok(resp);
    }
}