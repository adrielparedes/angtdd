package com.rh.plane.chain;

import java.util.List;

import com.rh.plane.exceptions.NoSePuedeEncontrarMejorAsientoException;
import com.rh.plane.model.Asiento;

public class AsientoNullChecker extends Chain {

	@Override
	public Asiento execute(List<Asiento> asientos) {
		throw new NoSePuedeEncontrarMejorAsientoException(
				"Mejor asiento no encontrado");
	}

}
