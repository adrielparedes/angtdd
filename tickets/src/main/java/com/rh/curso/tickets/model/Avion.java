package com.rh.curso.tickets.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Avion.findAll", query = "select avion from Avion avion") })
public class Avion extends Model {

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Asiento> asientos;

	@Column(unique = true)
	private String nombre;

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addAsientos(List<Asiento> asientos2) {
		this.asientos.addAll(asientos2);
	}

	public Asiento getAsiento(Long asientoId) {
		for (Asiento asiento : asientos) {
			if (asientoId.equals(asiento.getId())) {
				return asiento;
			}
		}
		return null;
	}
}
