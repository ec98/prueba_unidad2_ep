package com.uce.edu.demo.modelo.repository;

import java.time.LocalDateTime;

public class PacienteLigero {

	private String cedula;
	private String nombre;
	private LocalDateTime fechaNacimiento;
	private String genero;

	public PacienteLigero() {
		// TODO Auto-generated constructor stub
	}

	public PacienteLigero(String cedula, String nombre, LocalDateTime fechaNacimiento, String genero) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "PacienteLigero [cedula=" + cedula + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento
				+ ", genero=" + genero + "]";
	}

	// GET Y SET
	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
