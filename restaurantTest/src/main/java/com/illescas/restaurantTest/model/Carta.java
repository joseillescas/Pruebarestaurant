package com.illescas.restaurantTest.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection =  "Carta")
public class Carta {
	
	private Long id;
	private String nombre;
	private String categoria;
	private Integer cantidad;
	
	
	private List<Plato> platos;
}
