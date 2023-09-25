/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.model;

import com.duberlyguarnizo.passiveoperationsservice.architecture.DomainModel;
import com.duberlyguarnizo.passiveoperationsservice.domain.enums.OperationChannel;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a withdrawal transaction.
 */
@Getter
@Setter
@Builder
@DomainModel
public class Withdrawal {
  private UUID originAccountId;
  private Double amount;
  private OperationChannel operationChannel;
}
