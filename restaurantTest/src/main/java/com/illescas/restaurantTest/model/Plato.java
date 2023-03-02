package com.illescas.restaurantTest.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection =  "Plato")
public class Plato {

	private Long id;
	private String nombre;
	private String descripcion;
	private Integer precio;
}
