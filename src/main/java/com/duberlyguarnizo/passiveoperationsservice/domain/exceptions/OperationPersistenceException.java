/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.domain.exceptions;

/**
 * Exception thrown when an error occurs during persistence operations related to
 * an infrastructure service or entity.
 */
public class OperationPersistenceException extends RuntimeException {
  public OperationPersistenceException(String message) {
    super(message);
  }

  public OperationPersistenceException(String message, Throwable cause) {
    super(message, cause);
  }
}
