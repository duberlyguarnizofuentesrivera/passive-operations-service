/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.service;

import com.duberlyguarnizo.passiveoperationsservice.domain.enums.TransactionType;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Deposit;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Transaction;
import com.duberlyguarnizo.passiveoperationsservice.domain.repository.DepositPersistence;
import com.duberlyguarnizo.passiveoperationsservice.exceptions.InsufficientFundsException;
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
  private final InterServiceOperations interServiceOperations;

  public DepositService(DepositPersistence persistence,
                        InterServiceOperations interServiceOperations) {
    this.persistence = persistence;
    this.interServiceOperations = interServiceOperations;
  }

  public void transferMoney(Deposit deposit) {
    if (interServiceOperations.accountGetCurrentBalance(deposit.getOriginAccountId()) < deposit.getAmount()) {
      throw new InsufficientFundsException("Insufficient funds to perform this operation");
    }
    persistence.createDeposit(deposit);
    Transaction transaction = Transaction.builder()
        .originAccountId(deposit.getOriginAccountId())
        .destinationAccountId(deposit.getDestinationAccountId())
        .amount(deposit.getAmount())
        .transactionType(TransactionType.DEPOSIT)
        .operationChannel(deposit.getOperationChannel())
        .build();
    interServiceOperations.accountAddToBalance(deposit.getDestinationAccountId(),
        deposit.getAmount());
    interServiceOperations.accountSubtractFromBalance(deposit.getOriginAccountId(),
        deposit.getAmount());
    interServiceOperations.createTransaction(transaction);
  }
}
