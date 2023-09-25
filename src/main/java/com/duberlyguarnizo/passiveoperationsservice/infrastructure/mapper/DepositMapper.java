/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.mapper;

import com.duberlyguarnizo.passiveoperationsservice.domain.model.Deposit;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence.DepositEntity;
import java.time.Instant;

/**
 * The DepositMapper class provides static methods for converting Deposit objects
 * to DepositEntity objects and vice versa.
 */
public final class DepositMapper {
  private DepositMapper() {
  }

  /**
   * Creates a deposit entity based on the given deposit object.
   *
   * @param deposit the deposit object to convert to an entity
   * @return the deposit entity
   */
  public static DepositEntity toEntity(final Deposit deposit) {
    return DepositEntity.builder()
            .amount(deposit.getAmount())
            .originAccountId(deposit.getOriginAccountId())
            .destinationAccountId(deposit.getDestinationAccountId())
            .operationChannel(deposit.getOperationChannel())
            .createdAt(Instant.now())
            .build();
  }

  /**
   * Creates a deposit object based on the given deposit entity.
   *
   * @param depositEntity the deposit entity to convert to a domain object
   * @return the deposit domain object
   */
  public static Deposit toDomain(final DepositEntity depositEntity) {
    return Deposit.builder()
            .amount(depositEntity.getAmount())
            .originAccountId(depositEntity.getOriginAccountId())
            .destinationAccountId(depositEntity.getDestinationAccountId())
            .operationChannel(depositEntity.getOperationChannel())
            .build();
  }
}
