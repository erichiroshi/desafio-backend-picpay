package com.erichiroshi.picpay.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erichiroshi.picpay.entity.WalletType;

public interface WalletTypeRepository extends JpaRepository<WalletType, Long> {

}
