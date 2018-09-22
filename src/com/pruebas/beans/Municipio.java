package com.pruebas.beans;

public class Municipio {
	
	private String nombre;
	private String comunidad;
	
	public Municipio(String nombre, String comunidad) {
		super();
		this.nombre = nombre;
		this.comunidad = comunidad;
	}
	
	@Override
	public String toString() {
		return "Municipio [nombre=" + nombre + ", comunidad=" + comunidad + "]";
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getComunidad() {
		return comunidad;
	}
	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}
	
	

}
