package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.repository.PacienteLigero;

public interface IGestorCitaMedicaService {

	public void insertarCita(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente);
	
	public int actualizarCitaQuery(String numero, String diagnostico, String receta, LocalDateTime fechaProximaCita);

	
	public List<PacienteLigero> reportePacientes(LocalDateTime fecha, String genero);

}
