package com.rh.plane.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import com.rh.plane.exceptions.NoSePuedeEncontrarMejorAsientoException;
import com.rh.plane.model.Asiento;
import com.rh.plane.model.Avion;
import com.rh.plane.test.fixture.AsientosFixture;

public class MejorAsientoTest {

	private AsientosFixture fixture;

	@Before
	public void setUp() {
		fixture = new AsientosFixture();
	}

	/**
	 * El mejor asientos disponible es el asiento que no tiene mas asientos
	 * delante de el.
	 * 
	 * Este test lo armo yo, ellos siguen con el resto.
	 */
	@Test
	public void busco_el_mejor_asiento_disponible() {

		Avion avion = fixture.getAvionSinAsientosDelante();
		Asiento asientos = avion.getMejorAsientoDisponible();

		assertTrue(asientos != null);

	}

	/**
	 * El mejor asientos disponible es el asiento que no tiene mas asientos
	 * delante de el.
	 * 
	 * Este test lo armo yo, ellos siguen con el resto.
	 */
	@Test(expected = NoSePuedeEncontrarMejorAsientoException.class)
	public void falla_al_tener_asientos_delante() {

		Avion avion = fixture.getAvionConAsientosDelante();
		Asiento asiento = avion.getMejorAsientoDisponible();

	}
}
