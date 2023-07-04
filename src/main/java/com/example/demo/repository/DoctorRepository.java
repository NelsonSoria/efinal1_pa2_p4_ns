package com.example.demo.repository;

import com.example.demo.repository.modelo.Doctor;

public interface DoctorRepository {
	public void insertar(Doctor doctor);
	public void eliminar(int id);
	public Doctor selecccionarPorID(int id);
	public void actualizar(Doctor doctor);
	
	public Doctor seleccionarPorCedula(String cedula);
	

}
