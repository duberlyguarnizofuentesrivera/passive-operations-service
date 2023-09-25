/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.repository;

import com.duberlyguarnizo.passiveoperationsservice.domain.exceptions.OperationPersistenceException;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Deposit;

/**
 * The DepositPersistence interface provides methods for creating deposits.
 */
public interface DepositPersistence {
  void createDeposit(Deposit deposit) throws OperationPersistenceException;


}
