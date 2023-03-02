package com.illescas.restaurantTest.service;

import java.util.List;

import com.illescas.restaurantTest.model.Restaurante;

public interface RestauranteService {
    List<Restaurante> getAllRestaurantes();
    Restaurante getRestauranteById(Long restauranteId);
    Restaurante createRestaurante(Restaurante restaurante);
    Restaurante updateRestaurante(Long restauranteId, Restaurante restauranteDetails);
    void deleteRestaurante(Long restauranteId);
}