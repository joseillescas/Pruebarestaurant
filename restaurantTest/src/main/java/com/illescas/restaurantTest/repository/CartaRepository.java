package com.illescas.restaurantTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.illescas.restaurantTest.model.Carta;

@Repository
public interface CartaRepository extends MongoRepository<Carta, Long>{

}
