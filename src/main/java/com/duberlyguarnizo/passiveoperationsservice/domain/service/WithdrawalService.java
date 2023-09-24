/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.service;

import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;
import org.springframework.stereotype.Service;

@Service
public interface WithdrawalService {
  public void withdrawMoney(Withdrawal withdrawal);
}
