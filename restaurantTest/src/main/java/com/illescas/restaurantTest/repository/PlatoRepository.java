package com.illescas.restaurantTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.illescas.restaurantTest.model.Plato;

@Repository
public interface PlatoRepository extends MongoRepository<Plato, Long>{

}
