package com.pruebas.beans;

import java.util.Optional;

public class Usuario {
	 
	private String nombre;
	private String apellido;
	private Optional<Integer> edad;
	private Direccion dir;
 
	public Usuario(String nombre, String apellido, Integer edad, Direccion dir) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = Optional.ofNullable(edad);
		this.dir=dir;
	}
		
	public Usuario() {
		
	}
 
	public String getNombre() {
		return nombre;
	}
 
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
 
	public String getApellido() {
		return apellido;
	}
 
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
 
	public Integer getEdad() {
		return edad.orElse(0);
	}
 
	public void setEdad(Integer edad) {
		this.edad = Optional.of(edad);
	}
 
 
 
	public Direccion getDir() {
		return dir;
	}
	public void setDir(Direccion dir) {
		this.dir = dir;
	}
	@Override
	public String toString() {
		return this.nombre+" "+this.apellido+" "+this.edad+" "+this.dir.getNombre();
	}
}

