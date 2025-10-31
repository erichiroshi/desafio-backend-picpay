package com.erichiroshi.picpay.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erichiroshi.picpay.entity.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {

}
