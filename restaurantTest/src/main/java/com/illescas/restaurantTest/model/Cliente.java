package com.illescas.restaurantTest.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection =  "Cliente")
public class Cliente {

	private Long id;
	private String nombre;
	private String apellido;
	private String cedula;
	private String correo;
	
	


}
