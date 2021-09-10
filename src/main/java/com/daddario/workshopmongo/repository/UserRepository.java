package com.daddario.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.MongoRepositoryConfigurationExtension;
import org.springframework.stereotype.Repository;

import com.daddario.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
