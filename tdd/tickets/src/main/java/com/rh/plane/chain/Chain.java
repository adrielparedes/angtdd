package com.rh.plane.chain;

import java.util.List;

import com.rh.plane.model.Asiento;

public abstract class Chain {

	private Chain chain;

	public abstract Asiento execute(List<Asiento> asientos);

	public Chain getChain() {
		return chain;
	}

	public void setChain(Chain chain) {
		this.chain = chain;
	}

}
