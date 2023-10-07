/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.model;

import com.duberlyguarnizo.passiveoperationsservice.architecture.DomainModel;
import com.duberlyguarnizo.passiveoperationsservice.domain.enums.ClientSpecialType;
import com.duberlyguarnizo.passiveoperationsservice.domain.enums.ClientType;
import com.duberlyguarnizo.passiveoperationsservice.domain.enums.OperationChannel;
import com.duberlyguarnizo.passiveoperationsservice.domain.enums.TransactionType;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@DomainModel
public class Transaction {
  UUID originAccountId;
  UUID destinationAccountId;
  double amount;
  double currentBalance;
  int monthlyTransactionCount;
  TransactionType transactionType;
  ClientType clientType;
  ClientSpecialType clientSpecialType;
  OperationChannel operationChannel;
}
