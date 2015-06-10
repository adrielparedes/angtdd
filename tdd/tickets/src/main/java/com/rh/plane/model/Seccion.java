package com.rh.plane.model;

import java.util.ArrayList;
import java.util.List;

public class Seccion {

	private List<Asiento> asientos;

	public Seccion() {
		this.asientos = new ArrayList<Asiento>();
	}

	public List<Asiento> getAsientos() {
		return asientos;
	}

	public void addAsiento(Asiento asiento) {
		this.asientos.add(asiento);
	}

}
