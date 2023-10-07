/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.service;

import com.duberlyguarnizo.passiveoperationsservice.domain.model.Transaction;
import java.util.UUID;

public interface InterServiceOperations {
  public double accountGetCurrentBalance(UUID accountId);

  public int accountGetCurrentNumberOfOperations(UUID accountId);

  public void accountAddToBalance(UUID accountId, double amount);

  public void accountSubtractFromBalance(UUID accountId, double amount);

  public void createTransaction(Transaction transaction);

}
