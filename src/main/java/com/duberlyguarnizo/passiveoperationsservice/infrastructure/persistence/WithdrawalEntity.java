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
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * WithdrawalEntity represents a withdrawal transaction in the system.
 * It is used to store information related to the withdrawal operation.
 */
@Getter
@Setter
@Builder
@ToString
@Document("withdrawals")
public class WithdrawalEntity {
  @Id
  @ToString.Exclude
  String id;
  private UUID originAccountId;
  private Double amount;
  private OperationChannel operationChannel;
  @ToString.Exclude
  private Instant createdAt;
}
