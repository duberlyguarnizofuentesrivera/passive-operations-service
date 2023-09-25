/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.port;

import com.duberlyguarnizo.passiveoperationsservice.domain.exceptions.OperationPersistenceException;
import com.duberlyguarnizo.passiveoperationsservice.domain.model.Withdrawal;
import com.duberlyguarnizo.passiveoperationsservice.domain.repository.WithdrawalPersistence;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.mapper.WithdrawalMapper;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence.WithdrawalEntityRepository;
import org.springframework.stereotype.Repository;

/**
 * WithdrawalPersistenceImpl is a class that implements the WithdrawalPersistence interface.
 * It provides methods for creating withdrawal records.
 */
@Repository
public class WithdrawalPersistenceImpl implements WithdrawalPersistence {
  private final WithdrawalEntityRepository repository;

  public WithdrawalPersistenceImpl(WithdrawalEntityRepository repository) {
    this.repository = repository;
  }

  @Override
  public void createWithdrawal(Withdrawal withdrawal) throws OperationPersistenceException {
    repository.save(WithdrawalMapper.toEntity(withdrawal));
  }

}
