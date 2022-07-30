package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.repository.Paciente;
import com.uce.edu.demo.modelo.repository.PacienteLigero;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public Paciente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Paciente paciente = this.buscar(id);
		this.entityManager.remove(paciente);
	}

	@Override
	public Paciente buscarCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Paciente> miQuery = this.entityManager
				.createQuery("SELECT p FROM Paciente p WHERE p.cedula =:datoCedula", Paciente.class);
		miQuery.setParameter("datoCedula", cedula);
		return miQuery.getSingleResult();
	}

	@Override
	public List<PacienteLigero> reportePacientes(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<PacienteLigero> miQuery = this.entityManager.createQuery(
				"SELECT NEW com.uce.edu.demo.modelo.repository.PacienteLigero(p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento >:datoFecha AND p.genero =:datoGenero",
				PacienteLigero.class);
		miQuery.setParameter("datoFecha", fecha);
		miQuery.setParameter("datoGenero", genero);
		return miQuery.getResultList();
	}

}
