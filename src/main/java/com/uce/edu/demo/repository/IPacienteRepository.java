package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.modelo.repository.Paciente;
import com.uce.edu.demo.modelo.repository.PacienteLigero;

public interface IPacienteRepository {

	public void insertar(Paciente paciente);

	public Paciente buscar(Integer id);

	public void actualizar(Paciente paciente);

	public void eliminar(Integer id);

	public Paciente buscarCedulaTyped(String cedula);

	public List<PacienteLigero> reportePacientes(LocalDateTime fecha, String genero);
}
