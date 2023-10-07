/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.port;

import com.duberlyguarnizo.passiveoperationsservice.domain.model.Transaction;
import com.duberlyguarnizo.passiveoperationsservice.domain.service.InterServiceOperations;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.event.InterServiceEvent;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.event.InterServiceEventType;
import com.duberlyguarnizo.passiveoperationsservice.infrastructure.event.TransactionCreatedEvent;
import java.time.Instant;
import java.util.UUID;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InterServiceOperationsImpl implements InterServiceOperations {
  private final KafkaTemplate<String, InterServiceEvent<?>> producer;

  public InterServiceOperationsImpl(KafkaTemplate<String, InterServiceEvent<?>> producer) {
    this.producer = producer;
  }

  @Override
  public double accountGetCurrentBalance(UUID accountId) {
    return 0;
  }

  @Override
  public int accountGetCurrentNumberOfOperations(UUID accountId) {
    return 0;
  }

  @Override
  public void accountAddToBalance(UUID accountId, double amount) {
  }

  @Override
  public void accountSubtractFromBalance(UUID accountId, double amount) {

  }

  @Override
  public void createTransaction(Transaction transaction) {
    var event = TransactionCreatedEvent.builder()
        .id(UUID.randomUUID().toString())
        .createdAt(Instant.now())
        .type(InterServiceEventType.TRANSACTION_CREATED)
        .data(transaction)
        .build();
    producer.send("transactions", event);
  }
}
