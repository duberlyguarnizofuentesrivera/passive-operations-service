/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence;

import com.duberlyguarnizo.passiveoperationsservice.domain.enums.OperationChannel;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document("deposits")
public class DepositEntity {
  @Id
  String id;
  private UUID originAccountId;
  private UUID destinationAccountId;
  private Double amount;
  private OperationChannel operationChannel;
  private Instant createdAt;
}
