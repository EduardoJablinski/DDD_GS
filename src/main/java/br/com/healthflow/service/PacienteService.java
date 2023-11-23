 package br.com.healthflow.service;

import br.com.healthflow.dominio.Mensageiro;
import br.com.healthflow.dominio.Paciente;
import br.com.healthflow.dominio.RepositorioPacientes;

public class PacienteService {

	private Mensageiro mensageiro;
	private RepositorioPacientes repositorioPacientes;
	
	public PacienteService(Mensageiro mensageiro, RepositorioPacientes repositorioPacientes) {
		this.mensageiro = mensageiro;
		this.repositorioPacientes = repositorioPacientes;
	}
	
	public void adicionar(Paciente paciente) {
		mensageiro.enviarMensagemDeBoasVindasPara(paciente);
		repositorioPacientes.adicionar(paciente);
		repositorioPacientes.fechar();
	}
}
