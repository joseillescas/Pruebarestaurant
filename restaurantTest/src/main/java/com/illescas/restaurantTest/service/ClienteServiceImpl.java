package com.illescas.restaurantTest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.illescas.restaurantTest.model.Cliente;
import com.illescas.restaurantTest.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(Long clienteId){
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        return cliente.get();
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Long clienteId, Cliente clienteDetails){
        Cliente cliente = getClienteById(clienteId);
        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellido(clienteDetails.getApellido());
        cliente.setCedula(clienteDetails.getCedula());
        cliente.setCorreo(clienteDetails.getCorreo());
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long clienteId){
        Cliente cliente = getClienteById(clienteId);
        clienteRepository.delete(cliente);
    }
}