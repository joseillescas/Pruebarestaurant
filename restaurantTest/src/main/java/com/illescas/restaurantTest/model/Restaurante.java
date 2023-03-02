package com.illescas.restaurantTest.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection =  "Restaurante")
public class Restaurante {

	private Long id;
		private String nombre;
		private String telefono;
		private String correo;
		private String direccion;

		private List<Cliente> clientes;
		private List<Carta> cartas;
}
