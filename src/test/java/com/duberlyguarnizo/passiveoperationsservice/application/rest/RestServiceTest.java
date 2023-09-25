/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.application.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import com.duberlyguarnizo.passiveoperationsservice.application.dto.DepositDto;
import com.duberlyguarnizo.passiveoperationsservice.application.dto.WithdrawalDto;
import com.duberlyguarnizo.passiveoperationsservice.domain.enums.OperationChannel;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Deposit;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;
import com.duberlyguarnizo.passiveoperationsservice.domain.service.DepositService;
import com.duberlyguarnizo.passiveoperationsservice.domain.service.WithdrawalService;
import java.util.UUID;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RestServiceTest {
  static private DepositDto depositDto;
  static private WithdrawalDto withdrawalDto;
  static private UUID accountId = UUID.randomUUID();
  @Captor
  ArgumentCaptor<Deposit> depositArgumentCaptor = ArgumentCaptor.forClass(Deposit.class);
  @Captor
  ArgumentCaptor<Withdrawal> withdrawalArgumentCaptor = ArgumentCaptor.forClass(Withdrawal.class);
  @InjectMocks
  private RestService restService;
  @Mock
  private DepositService depositService;
  @Mock
  private WithdrawalService withdrawalService;

  @BeforeAll
  static void setUp() {
    depositDto = DepositDto.builder()
        .amount(1000.0)
        .transactionMedia(DepositDto.TransactionMediaEnum.WEB)
        .destinationAccount(accountId)
        .build();
    withdrawalDto = WithdrawalDto.builder()
        .amount(500.5)
        .transactionMedia(WithdrawalDto.TransactionMediaEnum.ATM)
        .build();
  }

  @Test
  void doDeposit() {
    restService.doDeposit(depositDto, accountId);

    verify(depositService).depositMoney(depositArgumentCaptor.capture());
    assertEquals(accountId, depositArgumentCaptor.getValue().getDestinationAccountId());
    assertEquals(1000.0, depositArgumentCaptor.getValue().getAmount());
    assertEquals(OperationChannel.WEB, depositArgumentCaptor.getValue().getOperationChannel());
  }

  @Test
  void doWithdrawal() {
    restService.doWithdrawal(withdrawalDto, accountId);
    verify(withdrawalService).withdrawMoney(withdrawalArgumentCaptor.capture());
    assertEquals(accountId, withdrawalArgumentCaptor.getValue().getOriginAccountId());
    assertEquals(500.5, withdrawalArgumentCaptor.getValue().getAmount());
    assertEquals(OperationChannel.ATM, withdrawalArgumentCaptor.getValue().getOperationChannel());
  }
}