package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CitaMedica;
import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
@Transactional
public class CitaMedicaRepositoryImpl implements CitaMedicaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CitaMedica citamedica) {
		this.entityManager.persist(citamedica);
		
	}

	@Override
	public void eliminar(int id) {
		CitaMedica micita= this.selecccionarPorID(id);
		this.entityManager.remove(micita);
		
	}

	@Override
	public CitaMedica selecccionarPorID(int id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizar(CitaMedica citamedica) {
		this.entityManager.merge(citamedica);
		
	}

	@Override
	public CitaMedica seleccionarPorNumeroCita(int numeroCita) {
		Query miquery = this.entityManager.createQuery("Select c FROM CitaMedica c WHERE c.numeroCita=:datoNumeroCita");
		miquery.setParameter("datoNumeroCita", numeroCita);
		return (CitaMedica) miquery.getSingleResult();
	}

	

}
