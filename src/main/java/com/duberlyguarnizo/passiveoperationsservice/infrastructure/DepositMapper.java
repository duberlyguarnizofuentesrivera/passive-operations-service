/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure;

import com.duberlyguarnizo.passiveoperationsservice.domain.model.Deposit;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence.DepositEntity;
import java.time.Instant;

public final class DepositMapper {
  private DepositMapper() {
  }

  public static DepositEntity toEntity(final Deposit deposit) {
    return DepositEntity.builder()
            .amount(deposit.getAmount())
            .originAccountId(deposit.getOriginAccountId())
            .destinationAccountId(deposit.getDestinationAccountId())
            .operationChannel(deposit.getOperationChannel())
            .createdAt(Instant.now())
            .build();
  }

  public static Deposit toDomain(final DepositEntity depositEntity) {
    return Deposit.builder()
            .amount(depositEntity.getAmount())
            .originAccountId(depositEntity.getOriginAccountId())
            .destinationAccountId(depositEntity.getDestinationAccountId())
            .operationChannel(depositEntity.getOperationChannel())
            .build();
  }
}
