package com.rh.curso.tickets.model;

import javax.persistence.Entity;

@Entity
public class Asiento extends Model {

	private String nombre;

	private boolean ocupado;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String identificacion) {
		this.nombre = identificacion;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

}
