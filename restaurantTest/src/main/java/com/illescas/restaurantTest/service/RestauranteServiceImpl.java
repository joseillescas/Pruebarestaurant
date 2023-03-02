package com.illescas.restaurantTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.illescas.restaurantTest.controller.ResourceNotFoundException;
import com.illescas.restaurantTest.model.Restaurante;
import com.illescas.restaurantTest.repository.RestauranteRepository;

@Service
public class RestauranteServiceImpl implements RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> getAllRestaurantes() {
        return restauranteRepository.findAll();
    }

    @Override
    public Restaurante getRestauranteById(Long restauranteId){
        Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
        return restaurante.get();
    }

    @Override
    public Restaurante createRestaurante(Restaurante restaurante) {
        return restauranteRepository.save(restaurante);
    }

    @Override
    public Restaurante updateRestaurante(Long restauranteId, Restaurante restauranteDetails){
        Restaurante restaurante = getRestauranteById(restauranteId);
        restaurante.setNombre(restauranteDetails.getNombre());
        restaurante.setTelefono(restauranteDetails.getTelefono());
        restaurante.setCorreo(restauranteDetails.getCorreo());
        restaurante.setDireccion(restauranteDetails.getDireccion());
        return restauranteRepository.save(restaurante);
    }

    @Override
    public void deleteRestaurante(Long restauranteId){
        Restaurante restaurante = getRestauranteById(restauranteId);
        restauranteRepository.delete(restaurante);
    }
}