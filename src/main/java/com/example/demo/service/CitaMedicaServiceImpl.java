package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CitaMedicaRepository;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Doctor;
import com.example.demo.repository.modelo.Paciente;

@Service
public class CitaMedicaServiceImpl implements CitaMedicaService{

    @Autowired
    private CitaMedicaRepository citaMedicaRepository;
    @Autowired
    private  DoctorRepository doctorRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    
	@Override
	public void agendarCita(int numeroCita, LocalDateTime fechaCita, BigDecimal valorCita, String lugarCita,
			String cedulaDoctor, String cedulaPaciente) {
		CitaMedica micita= new CitaMedica();
		micita.setNumeroCita(numeroCita);
		micita.setFechaCita(fechaCita);
		micita.setValorCita(valorCita);
		micita.setLugarCita(lugarCita);
		micita.setDiagnostico(null);
		micita.setReceta(null);
		micita.setFechaProximaCita(null);
		
		Doctor docEncontrado = this.doctorRepository.seleccionarPorCedula(cedulaDoctor);
		Paciente pacEncontrado=this.pacienteRepository.seleccionarPorCedula(cedulaPaciente);
		
		micita.setDoctor(docEncontrado);
		micita.setPaciente(pacEncontrado);
		
		this.citaMedicaRepository.insertar(micita);
	}

	@Override
	public void actualizarCita(int numeroCita, String diagnostico, String receta, LocalDateTime fechaProximaCita) {
		CitaMedica actualizarCita= this.citaMedicaRepository.seleccionarPorNumeroCita(numeroCita);
		actualizarCita.setDiagnostico(diagnostico);
		actualizarCita.setReceta(receta);
		actualizarCita.setFechaProximaCita(fechaProximaCita);
		this.citaMedicaRepository.actualizar(actualizarCita);
		
	}

}
