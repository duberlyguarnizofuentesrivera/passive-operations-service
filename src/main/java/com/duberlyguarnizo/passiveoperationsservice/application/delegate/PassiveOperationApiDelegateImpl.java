/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.application.delegate;

import com.duberlyguarnizo.passiveoperationsservice.application.dto.DepositDto;
import com.duberlyguarnizo.passiveoperationsservice.application.dto.WithdrawalDto;
import com.duberlyguarnizo.passiveoperationsservice.application.request.PassivesApiDelegate;
import com.duberlyguarnizo.passiveoperationsservice.application.rest.RestService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementation class for the PassiveApiDelegate interface.
 * This class provides methods to perform deposit and withdrawal
 * operations on an account using REST service.
 */
@Service
public class PassiveOperationApiDelegateImpl implements PassivesApiDelegate {
  private final RestService restService;

  public PassiveOperationApiDelegateImpl(RestService restService) {
    this.restService = restService;
  }

  /**
   * POST /passive/deposits/{accountId} : Create a deposit into an account.
   *
   * @param accountId  The account UUID to make the deposit on. (required)
   * @param depositDto (optional)
   * @return Deposit completed. (status code 200)
   */
  @Override
  public ResponseEntity<Void> depositIntoAccount(UUID accountId, DepositDto depositDto) {
    restService.doDeposit(depositDto, accountId);
    return ResponseEntity.ok().build();
  }

  /**
   * POST /passive/withdrawals/{accountId} : Withdraw an amount from an account.
   *
   * @param accountId     The account UUID where the money will be taken from. (required)
   * @param withdrawalDto (optional)
   * @return Withdraw completed. (status code 200)
   */
  @Override
  public ResponseEntity<Void> withdrawFromAccount(UUID accountId, WithdrawalDto withdrawalDto) {
    restService.doWithdrawal(withdrawalDto, accountId);
    return ResponseEntity.ok().build();
  }
}
