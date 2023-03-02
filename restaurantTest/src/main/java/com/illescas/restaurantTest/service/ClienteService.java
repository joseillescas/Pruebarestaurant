package com.illescas.restaurantTest.service;

import java.util.List;

import com.illescas.restaurantTest.model.Cliente;

public interface ClienteService {
    List<Cliente> getAllClientes();
    Cliente getClienteById(Long clienteId);
    Cliente createCliente(Cliente cliente);
    Cliente updateCliente(Long clienteId, Cliente clienteDetails);
    void deleteCliente(Long clienteId);
}