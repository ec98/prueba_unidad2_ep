package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.modelo.repository.CitaMedica;

@Repository
@Transactional
public class GestorCitaMedicaRepositoryImpl implements IGestorCitaMedicaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaMedica);
	}

	@Override
	public int actualizarCitaQuery(String numero, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		Query myQueryv4 = this.entityManager.createQuery(
				"UPDATE CitaMedica c SET c.diagnostico =:datoDiagnostico, c.receta =:datoReceta, c.fechaProximaCita =: datofechaProximaCita WHERE c.numeroCita =:datoNumeroCita");
		myQueryv4.setParameter("datoNumeroCita", numero);
		myQueryv4.setParameter("datoDiagnostico", diagnostico);
		myQueryv4.setParameter("datoReceta", receta);
		myQueryv4.setParameter("datofechaProximaCita", fechaProximaCita);
		return myQueryv4.executeUpdate(); // this return a int, actualiza los registros.
	}

	@Override
	public void actualizarCita(CitaMedica citaMedica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaMedica);
	}

	@Override
	public CitaMedica buscarPorNumero(String numeroCita) {
		// TODO Auto-generated method stub
		TypedQuery<CitaMedica> miQuery = this.entityManager
				.createQuery("SELECT c FROM CitaMedica c WHERE c.numeroCita =:numeroCita", CitaMedica.class);
		miQuery.setParameter("numeroCita", numeroCita);
		return miQuery.getSingleResult();
	}

}
