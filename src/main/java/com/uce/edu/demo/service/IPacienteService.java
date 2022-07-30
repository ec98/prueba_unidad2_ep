package com.uce.edu.demo.service;

import com.uce.edu.demo.modelo.repository.Paciente;

public interface IPacienteService {
	public void insertar(Paciente paciente);

	public Paciente buscar(Integer id);

	public void actualizar(Paciente paciente);

	public void eliminar(Integer id);
	
	public Paciente buscarCedulaTyped(String cedula);

}
