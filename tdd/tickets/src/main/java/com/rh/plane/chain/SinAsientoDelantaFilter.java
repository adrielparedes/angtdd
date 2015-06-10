package com.rh.plane.chain;

import java.util.List;

import com.rh.plane.model.Asiento;

public class SinAsientoDelantaFilter extends Chain {

	@Override
	public Asiento execute(List<Asiento> asientos) {
		for (Asiento asiento : asientos) {

			if (!asiento.hasAsientoDelante()) {
				return asiento;
			}
		}

		return this.getChain().execute(asientos);
	}
}
