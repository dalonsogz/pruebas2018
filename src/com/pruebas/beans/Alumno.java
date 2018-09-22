package com.pruebas.beans;

import java.time.LocalDate;

public class Alumno {
	
	private String nombre;
	private String apellido;
	private Integer edad;
	private LocalDate fechaNacim;
	private Escuela escuela;
	
	public Alumno(String nombre, String apellido, Integer edad, LocalDate fechaNacim, Escuela escuela) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacim = fechaNacim;
		this.escuela = escuela;
	}
	
	
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", fechaNacim=" + fechaNacim
				+ ", escuela=" + escuela + "]";
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
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public LocalDate getFechaNacim() {
		return fechaNacim;
	}
	public void setFechaNacim(LocalDate fechaNacim) {
		this.fechaNacim = fechaNacim;
	}
	public Escuela getEscuela() {
		return escuela;
	}
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
}
