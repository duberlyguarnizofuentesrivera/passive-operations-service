/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.mapper;

import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence.WithdrawalEntity;
import java.time.Instant;

/**
 * The WithdrawalMapper class is a utility class that provides methods for converting
 * between WithdrawalEntity and Withdrawal objects.
 */
public final class WithdrawalMapper {
  private WithdrawalMapper() {
    throw new UnsupportedOperationException(
        "WithdrawalMapper is a utility class and cannot be instantiated"
    );
  }

  /**
   * Converts a WithdrawalEntity object to a Withdrawal object.
   *
   * @param withdrawalEntity The WithdrawalEntity object to be converted.
   * @return The converted Withdrawal object.
   */
  public static Withdrawal toDomain(WithdrawalEntity withdrawalEntity) {
    return Withdrawal.builder()
            .originAccountId(withdrawalEntity.getOriginAccountId())
            .amount(withdrawalEntity.getAmount())
            .operationChannel(withdrawalEntity.getOperationChannel())
            .build();
  }

  /**
   * Converts a Withdrawal object to a WithdrawalEntity object.
   *
   * @param withdrawal The Withdrawal object to be converted.
   * @return The converted WithdrawalEntity object.
   */
  public static WithdrawalEntity toEntity(Withdrawal withdrawal) {
    return WithdrawalEntity.builder()
            .originAccountId(withdrawal.getOriginAccountId())
            .amount(withdrawal.getAmount())
            .operationChannel(withdrawal.getOperationChannel())
            .createdAt(Instant.now())
            .build();
  }
}
