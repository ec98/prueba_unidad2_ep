package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.repository.CitaMedica;
import com.uce.edu.demo.modelo.repository.Doctor;
import com.uce.edu.demo.modelo.repository.Paciente;
import com.uce.edu.demo.modelo.repository.PacienteLigero;
import com.uce.edu.demo.repository.IDoctorRepository;
import com.uce.edu.demo.repository.IGestorCitaMedicaRepository;
import com.uce.edu.demo.repository.IPacienteRepository;

@Service
public class GestorCitaMedicaServiceImpl implements IGestorCitaMedicaService {

	@Autowired
	private IGestorCitaMedicaRepository iGestorCitaMedicaRepository;

	@Autowired
	private IPacienteRepository iPacienteRepository;

	@Autowired
	private IDoctorRepository iDoctorRepository;

	@Override
	public void insertarCita(String numero, LocalDateTime fecha, BigDecimal valor, String lugar, String cedulaDoctor,
			String cedulaPaciente) {
		// TODO Auto-generated method stub
		Paciente p = this.iPacienteRepository.buscarCedulaTyped(cedulaPaciente);
		Doctor d = this.iDoctorRepository.buscarCedulaTyped(cedulaDoctor);

		CitaMedica cms = new CitaMedica();
		cms.setNumeroCita(numero);
		cms.setFechaCita(fecha);
		cms.setValorCita(valor);
		cms.setLugarCita(lugar);
		cms.setDoctor(d);
		cms.setPaciente(p);

		this.iGestorCitaMedicaRepository.insertar(cms);
	}

	@Override
	public int actualizarCitaQuery(String numero, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		return this.iGestorCitaMedicaRepository.actualizarCitaQuery(numero, diagnostico, receta, fechaProximaCita);
	}

	@Override
	public List<PacienteLigero> reportePacientes(LocalDateTime fecha, String genero) {
		// TODO Auto-generated method stub
		return this.iPacienteRepository.reportePacientes(fecha, genero);
	}

	@Override
	public void actualizarCita(String numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		// TODO Auto-generated method stub
		CitaMedica cm = this.iGestorCitaMedicaRepository.buscarPorNumero(numeroCita);
		cm.setDiagnostico(diagnostico);
		cm.setReceta(receta);
		cm.setFechaProximaCita(fechaProximaCita);

		this.iGestorCitaMedicaRepository.actualizarCita(cm);

	}

}
