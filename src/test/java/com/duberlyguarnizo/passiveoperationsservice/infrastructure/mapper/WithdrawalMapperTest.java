/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.duberlyguarnizo.passiveoperationsservice.domain.enums.OperationChannel;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence.WithdrawalEntity;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class WithdrawalMapperTest {
  private UUID originAccountId = UUID.randomUUID();

  private Withdrawal withdrawal = Withdrawal.builder()
      .amount(500.0)
      .originAccountId(originAccountId)
      .operationChannel(OperationChannel.ATM)
      .build();
  private WithdrawalEntity withdrawalEntity = WithdrawalEntity.builder()
      .id("abdf544fdsfdfdsafsd")
      .amount(500.0)
      .originAccountId(originAccountId)
      .operationChannel(OperationChannel.ATM)
      .createdAt(Instant.now())
      .build();

  @Test
  void toDomain() {
    // Comparing Strings because id and createdAt are not compared.
    assertEquals(withdrawal.toString(), WithdrawalMapper.toDomain(withdrawalEntity).toString());
  }

  @Test
  void toEntity() {
    assertEquals(withdrawalEntity.toString(), WithdrawalMapper.toEntity(withdrawal).toString());
  }
}