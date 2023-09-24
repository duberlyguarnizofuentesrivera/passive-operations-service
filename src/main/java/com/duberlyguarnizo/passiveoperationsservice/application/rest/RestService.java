/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.application.rest;

import com.duberlyguarnizo.passiveoperationsservice.application.dto.DepositDto;
import com.duberlyguarnizo.passiveoperationsservice.application.dto.WithdrawalDto;
import com.duberlyguarnizo.passiveoperationsservice.domain.enums.OperationChannel;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Deposit;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;
import com.duberlyguarnizo.passiveoperationsservice.domain.service.DepositService;
import com.duberlyguarnizo.passiveoperationsservice.domain.service.WithdrawalService;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class RestService {
  private final DepositService depositService;
  private final WithdrawalService withdrawalService;

  public RestService(DepositService depositService, WithdrawalService withdrawalService) {
    this.depositService = depositService;
    this.withdrawalService = withdrawalService;
  }

  public void doDeposit(DepositDto dto, UUID originAccount) {
    Deposit deposit = Deposit.builder()
            .originAccountId(originAccount)
            .destinationAccountId(dto.getDestinationAccount())
            .amount(dto.getAmount())
            .operationChannel(OperationChannel.valueOf(dto.getTransactionMedia().name()))
            .build();
    depositService.depositMoney(deposit);
  }

  public void doWithdrawal(WithdrawalDto dto, UUID originAccount) {
    Withdrawal withdrawal = Withdrawal.builder()
            .originAccountId(originAccount)
            .amount(dto.getAmount())
            .operationChannel(OperationChannel.valueOf(dto.getTransactionMedia().name()))
            .build();
    withdrawalService.withdrawMoney(withdrawal);
  }
}
