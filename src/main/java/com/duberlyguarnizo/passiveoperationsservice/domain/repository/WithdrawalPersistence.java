/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.repository;

import com.duberlyguarnizo.passiveoperationsservice.domain.exceptions.OperationPersistenceException;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;

public interface WithdrawalPersistence {
  void createWithdrawal(Withdrawal withdrawal) throws OperationPersistenceException;
}
