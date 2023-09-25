/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.port;

import com.duberlyguarnizo.passiveoperationsservice.domain.exceptions.OperationPersistenceException;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Deposit;
import com.duberlyguarnizo.passiveoperationsservice.domain.repository.DepositPersistence;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.mapper.DepositMapper;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence.DepositEntityRepository;
import org.springframework.stereotype.Repository;

/**
 * A class that implements the DepositPersistence interface.
 * This class is responsible for persisting deposit data to the database.
 */
@Repository
public class DepositPersistenceImpl implements DepositPersistence {
  private final DepositEntityRepository repository;

  public DepositPersistenceImpl(DepositEntityRepository repository) {
    this.repository = repository;
  }

  @Override
  public void createDeposit(Deposit deposit) throws OperationPersistenceException {
    repository.save(DepositMapper.toEntity(deposit));
  }

}
