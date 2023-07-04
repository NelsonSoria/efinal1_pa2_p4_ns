package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.objenesis.instantiator.sun.MagicInstantiator;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;
import com.example.demo.service.CitaMedicaService;
import com.example.demo.service.DoctorService;
import com.example.demo.service.PacienteService;

@SpringBootApplication
public class Efinal1Pa2P4NsApplication implements CommandLineRunner{
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private CitaMedicaService citaMedicaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Efinal1Pa2P4NsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Doctor miDoc1= new Doctor();
		miDoc1.setCedula("123");
		miDoc1.setNombre("Nelson");
		miDoc1.setApellido("Soria");
		miDoc1.setFechaNacimiento(LocalDate.of(2001, 9, 2));
		miDoc1.setNumeroConsultorio("01");
		miDoc1.setCodigoSenescyt("c001");
		miDoc1.setGenero("M");
		
		
		Paciente p1= new Paciente();
		p1.setCedula("593");
		p1.setNombre("Anahy");
		p1.setApellido("Sanchez");
		p1.setFechaNacimiento(LocalDate.of(1999, 3, 2));
		p1.setCodigoSeguro("i003");
		p1.setEstatura(185);
		p1.setPeso(65);
		p1.setGenero("F");
		
		
		this.doctorService.guardar(miDoc1);
		this.pacienteService.guardar(p1);
		
		this.citaMedicaService.agendarCita(1, LocalDateTime.of(2023, 6,12,1,5), new BigDecimal(30), "Quito", "123", "593");
		this.citaMedicaService.actualizarCita(1, "Dolor cabeza", "Paracetamol", LocalDateTime.of(2023, 9, 12, 3, 15));
		
		
	}

}
