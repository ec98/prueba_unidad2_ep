package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.repository.Doctor;
import com.uce.edu.demo.modelo.repository.Paciente;
import com.uce.edu.demo.service.IDoctorService;
import com.uce.edu.demo.service.IGestorCitaMedicaService;
import com.uce.edu.demo.service.IPacienteService;

@SpringBootApplication
public class PruebaUnidad2EpApplication implements CommandLineRunner {
	private static final Logger Logger = LoggerFactory.getLogger(PruebaUnidad2EpApplication.class);

	@Autowired
	private IPacienteService iPacienteService;

	@Autowired
	private IDoctorService iDoctorService;

	@Autowired
	private IGestorCitaMedicaService iGestorCitaMedicaService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad2EpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// 1.Funcionalidad CRUD para Doctores
		Paciente paciente = new Paciente();
		paciente.setApellido("Marcos");
		paciente.setCedula("17282222");
		paciente.setCodigoSeguro("#2233");
		paciente.setEstatura("1.60 m");
		paciente.setFechaNacimiento(LocalDateTime.of(2001, 10, 12, 11, 9, 1));
		paciente.setGenero("Femenino");
		paciente.setNombre("Casas");
		paciente.setPeso("60 kg");

		 //this.iPacienteService.insertar(paciente);

		// 2.Funcionalidad CRUD para Pacientes
		Doctor doctor = new Doctor();
		doctor.setApellido("Jaramillo");
		doctor.setCedula("182829211");
		doctor.setCodigoSenescyt("0001");
		doctor.setFechaNacimiento(LocalDateTime.of(2001, 8, 23, 12, 29, 11));
		doctor.setGenero("Femenino");
		doctor.setNombre("Carla");
		doctor.setNumeroConsultorio("#001-A");

		// this.iDoctorService.insertar(doctor);

		// 3.Funcionalidad agendamiento cita medica

		this.iGestorCitaMedicaService.insertarCita("1", LocalDateTime.of(2019, 11, 11, 22, 3, 4), new BigDecimal("400"),
				"Hospital Andrade Marin", doctor.getCedula(), paciente.getCedula());

		// 4.Funcionalidad actualización cita medica
		this.iGestorCitaMedicaService.actualizarCitaQuery("1", "Operacion del oido","Quintaro",LocalDateTime.of(2020, 12, 02, 05, 11, 07));

		// 5.Funcionalidad reporte de pacientes
		//paciente.setFechaNacimiento(LocalDateTime.of(2011, 12, 2, 12, 11, 1));
		//paciente.setFechaNacimiento(LocalDateTime.of(2001, 14, 12, 11, 9, 1));
		this.iGestorCitaMedicaService.reportePacientes(LocalDateTime.of(2001, 10, 12, 11, 9, 1), "Femenino");

	}

}
