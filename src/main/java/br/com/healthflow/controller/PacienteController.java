package br.com.healthflow.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.healthflow.dominio.Mensageiro;
import br.com.healthflow.dominio.Paciente;
import br.com.healthflow.infra.dao.PacienteDAO;
import br.com.healthflow.service.PacienteService;


@Path("pacientes")
public class PacienteController {

	private PacienteDAO pacienteDao;
	private PacienteService pacienteService;
	
	public PacienteController() {
		Mensageiro mensageiro = new Mensageiro();
		pacienteDao = new PacienteDAO();
		
		pacienteService = new PacienteService(mensageiro, pacienteDao);
	}
	
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Response adicionar(Paciente paciente) {
		pacienteService.adicionar(paciente);
		return Response
				.status(Response.Status.CREATED)
				.build();
	}
}
