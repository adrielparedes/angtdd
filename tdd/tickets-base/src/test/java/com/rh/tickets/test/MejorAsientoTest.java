package com.rh.tickets.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.rh.tickets.fixture.AvionFixture;
import com.rh.tickets.model.Asiento;
import com.rh.tickets.model.Avion;

public class MejorAsientoTest {

	private AvionFixture avionFixture;

	@Test
	public void necesito_obtener_los_mejores_asientos_disponibles_que_son_el_A1_y_el_A3() {
		Avion avion = avionFixture.crearAvionConAsientosDisponibles();
		List<Asiento> mejoresAsientos = avion
				.dameLosMejoresAsientosDisponibles();
		assertEquals(2, mejoresAsientos.size());
		assertTrue(buscarAsientos(mejoresAsientos, "A1") != null);
		assertTrue(buscarAsientos(mejoresAsientos, "A3") != null);
	}

	private Asiento buscarAsientos(List<Asiento> mejoresAsientos, String string) {
		for (Asiento asiento : mejoresAsientos) {
			if (asiento.getIdentificador().equals(string)) {
				return asiento;
			}
		}
		return null;
	}
}
