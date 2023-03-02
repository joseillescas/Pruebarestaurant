package com.illescas.restaurantTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.illescas.restaurantTest.model.Carta;
import com.illescas.restaurantTest.repository.CartaRepository;

@Service 
public class CartaServiceImpl implements CartaService {

    @Autowired
    private CartaRepository cartaRepository;

    @Override
    public List<Carta> getAllCartas() {
        return cartaRepository.findAll();
    }

    @Override
    public Carta getCartaById(Long cartaId){
        Optional<Carta> carta = cartaRepository.findById(cartaId);
        if (!carta.isPresent()) {}
        return carta.get();
    }

    @Override
    public Carta createCarta(Carta carta) {
        return cartaRepository.save(carta);
    }

    @Override
    public Carta updateCarta(Long cartaId, Carta cartaDetails){
        Carta carta = getCartaById(cartaId);
        carta.setNombre(cartaDetails.getNombre());
        carta.setCategoria(cartaDetails.getCategoria());
        carta.setCantidad(cartaDetails.getCantidad());
        return cartaRepository.save(carta);
    }

    @Override
    public void deleteCarta(Long cartaId){
        Carta carta = getCartaById(cartaId);
        cartaRepository.delete(carta);
    }
}