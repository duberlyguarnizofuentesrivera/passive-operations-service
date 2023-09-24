/*
 * Copyright (c) 2023. Code by Duberly Guarnizo <duberlygfr@gmail.com>.
 */

package com.duberlyguarnizo.passiveoperationsservice.infrastructure.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepositEntityRepository extends MongoRepository<DepositEntity, String> {
}
