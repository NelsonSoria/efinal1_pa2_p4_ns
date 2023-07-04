package com.example.demo.service;

import com.example.demo.repository.modelo.Paciente;

public interface PacienteService {
	public void guardar(Paciente paciente);
	public void actualizar(Paciente paciente);
	
	public Paciente buscarPorCedula(String cedula);

}
