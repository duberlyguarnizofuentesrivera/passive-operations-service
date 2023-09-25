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

/**
 * This class is responsible for handling deposit and withdrawal operations through REST APIs.
 */
@Service
public class RestService {
  private final DepositService depositService;
  private final WithdrawalService withdrawalService;

  public RestService(DepositService depositService, WithdrawalService withdrawalService) {
    this.depositService = depositService;
    this.withdrawalService = withdrawalService;
  }

  /**
   * Performs a deposit operation.
   *
   * @param dto           The deposit data transfer object containing the necessary
   *                      information for the deposit operation.
   * @param originAccount The UUID of the origin account from where the funds will be deposited.
   */
  public void doDeposit(DepositDto dto, UUID originAccount) {
    Deposit deposit = Deposit.builder()
            .originAccountId(originAccount)
            .destinationAccountId(dto.getDestinationAccount())
            .amount(dto.getAmount())
            .operationChannel(OperationChannel.valueOf(dto.getTransactionMedia().name()))
            .build();
    depositService.depositMoney(deposit);
  }

  /**
   * Performs a withdrawal operation.
   *
   * @param dto           The withdrawal data transfer object containing the necessary
   *                     information for the withdrawal operation.
   * @param originAccount The UUID of the origin account from where the funds will be withdrawn.
   */
  public void doWithdrawal(WithdrawalDto dto, UUID originAccount) {
    Withdrawal withdrawal = Withdrawal.builder()
            .originAccountId(originAccount)
            .amount(dto.getAmount())
            .operationChannel(OperationChannel.valueOf(dto.getTransactionMedia().name()))
            .build();
    withdrawalService.withdrawMoney(withdrawal);
  }
}
