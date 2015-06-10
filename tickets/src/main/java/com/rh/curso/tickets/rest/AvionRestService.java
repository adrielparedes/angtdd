package com.rh.curso.tickets.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rh.curso.tickets.model.Asiento;
import com.rh.curso.tickets.model.Avion;
import com.rh.curso.tickets.persistence.AvionHome;

@Stateless
@Path("aviones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AvionRestService {

	@Inject
	private AvionHome avionHome;

	@GET
	@Path("/")
	public List<Avion> getAll() {
		return avionHome.getAll();
	}

	@GET
	@Path("/{id}")
	public Avion getAvion(@PathParam("id") Long id) {
		return avionHome.findById(id);
	}

	@GET
	@Path("/{id}/asientos")
	public List<Asiento> getAsientos(@PathParam("id") Long id) {
		return this.getAvion(id).getAsientos();
	}

	@POST
	@Path("/")
	public Avion saveAvion(Avion avion) {
		return this.avionHome.save(avion);
	}

	@POST
	@Path("/{id}/asientos")
	public Avion addAsientos(@PathParam("id") Long id, List<Asiento> asientos) {
		Avion avion = this.getAvion(id);
		avion.addAsientos(asientos);
		this.avionHome.save(avion);
		return avion;
	}

	@POST
	@Path("/{avion}/asientos/{asiento}/ocupar")
	public Avion ocuparAsiento(@PathParam("avion") Long avionId,
			@PathParam("asiento") Long asientoId) {
		Avion avion = this.getAvion(avionId);
		Asiento asiento = avion.getAsiento(asientoId);
		asiento.setOcupado(true);
		this.saveAvion(avion);
		return avion;
	}

	@POST
	@Path("/{avion}/asientos/{asiento}/liberar")
	public Avion liberarAsiento(@PathParam("avion") Long avionId,
			@PathParam("asiento") Long asientoId) {
		Avion avion = this.getAvion(avionId);
		Asiento asiento = avion.getAsiento(asientoId);
		asiento.setOcupado(false);
		this.saveAvion(avion);
		return avion;
	}
}
