package com.rh.plane.test.fixture;

import java.util.ArrayList;
import java.util.List;

import com.rh.plane.model.Asiento;
import com.rh.plane.model.Avion;
import com.rh.plane.model.Seccion;

/**
 * Clase que me permite construir asientos para correr en los tests
 * 
 * @author aparedes
 *
 */
public class AsientosFixture {

	/**
	 * Devuelve un avion con asientos
	 * 
	 * @return
	 */
	public Avion getAvionSinAsientosDelante() {

		Avion avion = new Avion();

		List<Seccion> secciones = new ArrayList<Seccion>();

		Seccion seccion = new Seccion();
		Asiento asiento1 = new Asiento();
		asiento1.setHasAsientoDelante(false);

		seccion.addAsiento(asiento1);

		secciones.add(seccion);

		avion.setSecciones(secciones);
		return avion;
	}

	/**
	 * Devuelve un avion con asientos
	 * 
	 * @return
	 */
	public Avion getAvionConAsientosDelante() {

		Avion avion = new Avion();

		List<Seccion> secciones = new ArrayList<Seccion>();

		Seccion seccion = new Seccion();
		Asiento asiento1 = new Asiento();
		asiento1.setHasAsientoDelante(true);

		seccion.addAsiento(asiento1);

		secciones.add(seccion);

		avion.setSecciones(secciones);
		return avion;
	}
}
