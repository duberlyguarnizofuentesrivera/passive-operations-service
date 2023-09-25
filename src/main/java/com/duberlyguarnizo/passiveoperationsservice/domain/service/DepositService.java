/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.service;

import com.duberlyguarnizo.passiveoperationsservice.domain.model.Deposit;
import com.duberlyguarnizo.passiveoperationsservice.domain.repository.DepositPersistence;
import org.springframework.stereotype.Service;

/**
 * A class that provides a service for depositing money.
 *
 * <p>
 * The DepositService class is responsible for handling deposit operations by interacting with
 * a DepositPersistence object.
 * </p>
 */
@Service
public class DepositService {
  private final DepositPersistence persistence;

  public DepositService(DepositPersistence persistence) {
    this.persistence = persistence;
  }

  public void depositMoney(Deposit deposit) {
    persistence.createDeposit(deposit);
  }
}
