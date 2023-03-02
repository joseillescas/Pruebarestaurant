package com.illescas.restaurantTest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.illescas.restaurantTest.model.Restaurante;
import com.illescas.restaurantTest.repository.RestauranteRepository;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;

	@GetMapping("/")
	public List<Restaurante> getAllRestaurantes() {
		return restauranteRepository.findAll();
	}

	@PostMapping("/")
	public Restaurante addRestaurante(@RequestBody Restaurante restaurante) {
		return restauranteRepository.save(restaurante);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> getRestauranteById(@PathVariable(value = "id") Long restauranteId)
			throws ResourceNotFoundException {
		Restaurante restaurante = restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurante no encontrado con el id :: " + restauranteId));
		return ResponseEntity.ok().body(restaurante);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Restaurante> updateRestaurante(@PathVariable(value = "id") Long restauranteId,
			@RequestBody Restaurante restauranteDetails) throws ResourceNotFoundException {
		Restaurante restaurante = restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurante no encontrado con el id :: " + restauranteId));

		restaurante.setNombre(restauranteDetails.getNombre());
		restaurante.setTelefono(restauranteDetails.getTelefono());
		restaurante.setCorreo(restauranteDetails.getCorreo());
		restaurante.setDireccion(restauranteDetails.getDireccion());
		final Restaurante updatedRestaurante = restauranteRepository.save(restaurante);
		return ResponseEntity.ok(updatedRestaurante);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteRestaurante(@PathVariable(value = "id") Long restauranteId)
			throws ResourceNotFoundException {
		Restaurante restaurante = restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurante no encontrado con el id :: " + restauranteId));

		restauranteRepository.delete(restaurante);
		Map<String, Boolean> response = new HashMap();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}