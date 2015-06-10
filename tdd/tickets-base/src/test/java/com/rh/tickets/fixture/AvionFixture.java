package com.rh.tickets.fixture;

import com.rh.tickets.model.Asiento;
import com.rh.tickets.model.Avion;

public class AvionFixture {

	public Avion crearAvionConAsientosDisponibles() {

		Avion avion = new Avion();
		Asiento a1 = new Asiento();
		a1.setIdentificacion("A1");

		Asiento a2 = new Asiento();
		a1.setIdentificacion("A2");

		Asiento a3 = new Asiento();
		a1.setIdentificacion("A3");

		Asiento a4 = new Asiento();
		a1.setIdentificacion("A4");

		return avion;
	}

}
