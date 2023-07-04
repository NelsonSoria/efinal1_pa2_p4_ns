package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface CitaMedicaService {
	
	public void agendarCita(int numeroCita,LocalDateTime fechaCita,
			BigDecimal valorCita,String lugarCita,String cedulaDoctor,String cedulaPaciente);
	
	public void actualizarCita(int numeroCita,String diagnostico,String receta,LocalDateTime fechaProximaCita);
	

}
