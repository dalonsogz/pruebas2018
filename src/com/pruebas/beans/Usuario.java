package com.pruebas.beans;

public class Usuario {
	 
	private String nombre;
	private String apellido;
	private int edad;
	private Direccion dir;
 
	public Usuario(String nombre, String apellido, int edad, Direccion dir) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
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
 
	public int getEdad() {
		return edad;
	}
 
	public void setEdad(int edad) {
		this.edad = edad;
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

