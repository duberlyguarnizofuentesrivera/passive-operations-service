/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * This interface represents a repository for managing deposit entities.
 * It provides various methods for CRUD operations on deposit entities.
 * It extends the MongoRepository interface to leverage MongoDB's built-in functionality.
 */
public interface DepositEntityRepository extends MongoRepository<DepositEntity, String> {
}
