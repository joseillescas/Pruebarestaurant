package com.illescas.restaurantTest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.illescas.restaurantTest.model.Restaurante;

@Repository
public interface RestauranteRepository extends MongoRepository<Restaurante, Long>{

}
