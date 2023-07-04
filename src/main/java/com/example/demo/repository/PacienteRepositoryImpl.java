package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;



@Repository
@Transactional
public class PacienteRepositoryImpl implements PacienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void insertar(Paciente paciente) {
		this.entityManager.persist(paciente);
		
	}

	@Override
	public void actualizar(Paciente paciente) {
		this.entityManager.merge(paciente);
		
	}

	@Override
	public Paciente seleccionarPorCedula(String cedula) {
		Query miquery = this.entityManager.createQuery("Select p FROM Paciente p WHERE p.cedula=:datoCedula");
		miquery.setParameter("datoCedula", cedula);
		return (Paciente) miquery.getSingleResult();
	}

}
