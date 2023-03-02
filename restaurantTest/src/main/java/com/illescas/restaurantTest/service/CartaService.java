package com.illescas.restaurantTest.service;

import java.util.List;

import com.illescas.restaurantTest.model.Carta;

public interface CartaService {
    List<Carta> getAllCartas();
    Carta getCartaById(Long cartaId);
    Carta createCarta(Carta carta);
    Carta updateCarta(Long cartaId, Carta cartaDetails);
    void deleteCarta(Long cartaId);
}