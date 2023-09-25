/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.service;

import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;
import com.duberlyguarnizo.passiveoperationsservice.domain.repository.WithdrawalPersistence;
import org.springframework.stereotype.Service;

/**
 * A service class for handling withdrawal operations.
 */
@Service
public class WithdrawalService {
  private final WithdrawalPersistence persistence;

  public WithdrawalService(WithdrawalPersistence persistence) {
    this.persistence = persistence;
  }

  public void withdrawMoney(Withdrawal withdrawal) {
    persistence.createWithdrawal(withdrawal);
  }
}
