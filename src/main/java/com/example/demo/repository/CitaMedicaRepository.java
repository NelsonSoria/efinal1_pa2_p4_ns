package com.example.demo.repository;

import com.example.demo.repository.modelo.CitaMedica;

public interface CitaMedicaRepository {
	public void insertar(CitaMedica citamedica);
	public void eliminar(int id);
	public CitaMedica selecccionarPorID(int id);
	public void actualizar(CitaMedica citamedica);
	
	public CitaMedica seleccionarPorNumeroCita(int numeroCita);
}
