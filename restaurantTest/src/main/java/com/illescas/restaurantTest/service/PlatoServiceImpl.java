package com.illescas.restaurantTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.illescas.restaurantTest.controller.ResourceNotFoundException;
import com.illescas.restaurantTest.model.Plato;
import com.illescas.restaurantTest.repository.PlatoRepository;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    @Override
    public List<Plato> getAllPlatos() {
        return platoRepository.findAll();
    }

    @Override
    public Plato getPlatoById(Long platoId) throws ResourceNotFoundException {
        Optional<Plato> plato = platoRepository.findById(platoId);
        if (!plato.isPresent()) {
            throw new ResourceNotFoundException("Plato con id " + platoId + " no encontrado");
        }
        return plato.get();
    }

    @Override
    public Plato createPlato(Plato plato) {
        return platoRepository.save(plato);
    }

    @Override
    public Plato updatePlato(Long platoId, Plato platoDetails) throws ResourceNotFoundException {
        Plato plato = getPlatoById(platoId);
        plato.setNombre(platoDetails.getNombre());
        plato.setDescripcion(platoDetails.getDescripcion());
        plato.setPrecio(platoDetails.getPrecio());
        return platoRepository.save(plato);
    }

    @Override
    public void deletePlato(Long platoId) throws ResourceNotFoundException {
        Plato plato = getPlatoById(platoId);
        platoRepository.delete(plato);
    }
}