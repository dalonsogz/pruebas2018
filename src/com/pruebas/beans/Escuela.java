package com.pruebas.beans;

import java.time.LocalDate;

public class Escuela {
	
	private String nombre;
	private Municipio municipio;
	private Integer distrito;
	private LocalDate date;
	
	public Escuela(String nombre, Municipio municipio, Integer distrito, LocalDate date) {
		super();
		this.nombre = nombre;
		this.municipio = municipio;
		this.distrito = distrito;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Escuela [nombre=" + nombre + ", municipio=" + municipio + ", distrito=" + distrito + ", date=" + date
				+ "]";
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getDistrito() {
		return distrito;
	}
	public void setDistrito(Integer distrito) {
		this.distrito = distrito;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	
	

}
