package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

import com.uce.edu.demo.modelo.repository.CitaMedica;

public interface IGestorCitaMedicaRepository {

	public void insertar(CitaMedica citaMedica);

	public int actualizarCitaQuery(String numero, String diagnostico, String receta, LocalDateTime fechaProximaCita);
	
}
