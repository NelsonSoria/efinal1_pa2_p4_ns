package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Doctor;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class DoctorRepositoryImpl implements DoctorRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Doctor doctor) {
		this.entityManager.persist(doctor);
	}

	@Override
	public void eliminar(int id) {
		Doctor doc= this.selecccionarPorID(id);
		this.entityManager.remove(doc);
	}
	@Override
	public Doctor selecccionarPorID(int id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void actualizar(Doctor doctor) {
		this.entityManager.merge(doctor);
		
	}

	@Override
	public Doctor seleccionarPorCedula(String cedula) {
		Query miquery = this.entityManager.createQuery("Select d FROM Doctor d WHERE d.cedula=:datoCedula");
		miquery.setParameter("datoCedula", cedula);
		return (Doctor) miquery.getSingleResult();
	}

}
