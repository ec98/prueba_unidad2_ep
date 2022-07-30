package com.uce.edu.demo.repository;

import com.uce.edu.demo.modelo.repository.Doctor;

public interface IDoctorRepository {

	public void insertar(Doctor doctor);

	public Doctor buscar(Integer id);

	public void actualizar(Doctor doctor);

	public void eliminar(Integer id);
	
	public Doctor buscarCedulaTyped(String cedula);

}
