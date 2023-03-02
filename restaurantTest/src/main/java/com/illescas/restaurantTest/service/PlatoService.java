package com.illescas.restaurantTest.service;

import java.util.List;

import com.illescas.restaurantTest.controller.ResourceNotFoundException;
import com.illescas.restaurantTest.model.Plato;

public interface PlatoService {
    List<Plato> getAllPlatos();
    Plato getPlatoById(Long platoId) throws ResourceNotFoundException;
    Plato createPlato(Plato plato);
    Plato updatePlato(Long platoId, Plato platoDetails) throws ResourceNotFoundException;
    void deletePlato(Long platoId) throws ResourceNotFoundException;
}