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
		// Coreccion de la prueba unidad 2
		this.iGestorCitaMedicaService.actualizarCita("1", "Covid", "Paracetamol", LocalDateTime.now());
		
	}

}
