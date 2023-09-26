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
 * Represents a deposit entity in the system.
 * The class is persisted in the "deposits" collection in a document-oriented database.
 */
@Getter
@Setter
@Builder
@ToString
@Document("deposits")
public class DepositEntity {
  @Id
  @ToString.Exclude
  private String id;
  private UUID originAccountId;
  private UUID destinationAccountId;
  private Double amount;
  private OperationChannel operationChannel;
  @ToString.Exclude
  private Instant createdAt;
}
