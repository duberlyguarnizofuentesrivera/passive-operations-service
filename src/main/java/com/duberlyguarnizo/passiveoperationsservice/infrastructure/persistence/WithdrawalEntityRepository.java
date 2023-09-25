/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Interface for accessing the WithdrawalEntity collection in the MongoDB database
 * that provides default implementation for basic CRUD operations.*
 */
public interface WithdrawalEntityRepository extends MongoRepository<WithdrawalEntity, String> {
}
