/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.service;

import com.duberlyguarnizo.passiveoperationsservice.domain.enums.TransactionType;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Transaction;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;
import com.duberlyguarnizo.passiveoperationsservice.domain.repository.WithdrawalPersistence;
import com.duberlyguarnizo.passiveoperationsservice.exceptions.InsufficientFundsException;
import org.springframework.stereotype.Service;

/**
 * A service class for handling withdrawal operations.
 */
@Service
public class WithdrawalService {
  private final WithdrawalPersistence persistence;
  private final InterServiceOperations interServiceOperations;

  public WithdrawalService(WithdrawalPersistence persistence,
                           InterServiceOperations interServiceOperations) {
    this.persistence = persistence;
    this.interServiceOperations = interServiceOperations;
  }

  public void withdrawMoney(Withdrawal withdrawal) {
    if (interServiceOperations.accountGetCurrentBalance(
        withdrawal.getOriginAccountId()) < withdrawal.getAmount()) {
      throw new InsufficientFundsException("Insufficient funds to perform this operation");
    }
    persistence.createWithdrawal(withdrawal);
    Transaction transaction = Transaction.builder()
        .originAccountId(withdrawal.getOriginAccountId())
        .amount(withdrawal.getAmount())
        .transactionType(TransactionType.WITHDRAWAL)
        .operationChannel(withdrawal.getOperationChannel())
        .build();
    interServiceOperations.accountSubtractFromBalance(withdrawal.getOriginAccountId(),
        withdrawal.getAmount());
    interServiceOperations.createTransaction(transaction);

    //TODO: implement exception or message to kafka to notify error
  }
}
