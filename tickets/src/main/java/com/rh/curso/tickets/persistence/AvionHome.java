package com.rh.curso.tickets.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rh.curso.tickets.model.Avion;

public class AvionHome {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Avion> getAll() {
		return this.entityManager
				.createNamedQuery("Avion.findAll", Avion.class).getResultList();
	}

	public Avion save(Avion avion) {
		if (avion.getId() == null) {
			this.entityManager.persist(avion);
		} else {
			this.entityManager.merge(avion);
		}
		return avion;
	}

	public void delete(Long id) {
		Avion avion = this.findById(id);
		this.entityManager.remove(avion);
	}

	public Avion findById(Long id) {
		return this.entityManager.find(Avion.class, id);
	}
}
