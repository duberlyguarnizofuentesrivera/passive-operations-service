/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.duberlyguarnizo.passiveoperationsservice.domain.enums.OperationChannel;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Deposit;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence.DepositEntity;
import java.time.Instant;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class DepositMapperTest {
  private UUID originAccountId = UUID.randomUUID();
  private UUID destinationAccountId = UUID.randomUUID();
  private DepositEntity depositEntity = DepositEntity.builder()
      .id("fds5656fd65fd5s64fs4")
      .amount(100.0)
      .destinationAccountId(destinationAccountId)
      .originAccountId(originAccountId)
      .operationChannel(OperationChannel.WEB)
      .createdAt(Instant.now())
      .build();
  private Deposit deposit = Deposit.builder()
      .originAccountId(originAccountId)
      .amount(100.0)
      .destinationAccountId(destinationAccountId)
      .operationChannel(OperationChannel.WEB)
      .build();

  @Test
  void toEntity() {
    assertEquals(depositEntity.toString(), DepositMapper.toEntity(deposit).toString());
  }

  @Test
  void toDomain() {
    assertEquals(deposit.toString(), DepositMapper.toDomain(depositEntity).toString());
  }
}