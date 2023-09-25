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
 * Represents a deposit transaction.
 * This class provides the necessary fields and methods to perform a deposit operation.
 *
 * @see Getter
 * @see Setter
 * @see Builder
 */
@Getter
@Setter
@Builder
@DomainModel
public class Deposit {
  private UUID originAccountId;
  private UUID destinationAccountId;
  private Double amount;
  private OperationChannel operationChannel;
}
