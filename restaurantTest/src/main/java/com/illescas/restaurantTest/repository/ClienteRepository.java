package com.illescas.restaurantTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.illescas.restaurantTest.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Long> {
	

}
