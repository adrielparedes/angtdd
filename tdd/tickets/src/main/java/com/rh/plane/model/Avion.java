package com.rh.plane.model;

import java.util.ArrayList;
import java.util.List;

import com.rh.plane.chain.AsientoNullChecker;
import com.rh.plane.chain.Chain;
import com.rh.plane.chain.SinAsientoDelantaFilter;

/**
 * 
 * @author aparedes
 *
 */
public class Avion {

	private List<Seccion> secciones;
	private Chain chain;

	public Avion() {
		AsientoNullChecker nullChecker = new AsientoNullChecker();
		SinAsientoDelantaFilter sinAsientoDelanteFilter = new SinAsientoDelantaFilter();
		sinAsientoDelanteFilter.setChain(nullChecker);
		this.chain = sinAsientoDelanteFilter;
		this.setSecciones(new ArrayList<Seccion>());
	}

	public Asiento getMejorAsientoDisponible() {
		List<Seccion> secciones = this.getSecciones();
		Asiento asiento = this.getMejorAsientoDisponible(secciones);
		return asiento;
	}

	/**
	 * En base a una lista de secciones devuelve el mejor asientos disponible
	 * 
	 * @param secc
	 * @return
	 */
	private Asiento getMejorAsientoDisponible(List<Seccion> secc) {
		List<Asiento> asientos = new ArrayList<Asiento>();
		for (Seccion seccion : secc) {
			asientos.addAll(seccion.getAsientos());
		}
		Asiento mejorAsiento = this.chain.execute(asientos);
		return mejorAsiento;
	}

	private List<Seccion> getSecciones() {
		return this.secciones;
	}

	public void setSecciones(List<Seccion> secciones) {
		this.secciones = secciones;
	}

}
