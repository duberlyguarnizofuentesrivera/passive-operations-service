/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.mapper;

import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence.WithdrawalEntity;
import java.time.Instant;

public final class WithdrawalMapper {
  private WithdrawalMapper() {
    throw new UnsupportedOperationException("WithdrawalMapper is a utility class and cannot be instantiated");
  }

  public static Withdrawal toDomain(WithdrawalEntity withdrawalEntity) {
    return Withdrawal.builder()
            .originAccountId(withdrawalEntity.getOriginAccountId())
            .amount(withdrawalEntity.getAmount())
            .operationChannel(withdrawalEntity.getOperationChannel())
            .build();
  }

  public static WithdrawalEntity toEntity(Withdrawal withdrawal) {
    return WithdrawalEntity.builder()
            .originAccountId(withdrawal.getOriginAccountId())
            .amount(withdrawal.getAmount())
            .operationChannel(withdrawal.getOperationChannel())
            .createdAt(Instant.now())
            .build();
  }
}
