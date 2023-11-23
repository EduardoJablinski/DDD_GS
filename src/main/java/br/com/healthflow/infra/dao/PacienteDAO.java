package br.com.healthflow.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.healthflow.dominio.Paciente;
import br.com.healthflow.dominio.RepositorioPacientes;

public class PacienteDAO implements RepositorioPacientes {

	private Connection conexao;
	
	public PacienteDAO() {
		conexao = new ConnectionFactory().getConnection();
	}
	
	@Override
	public void adicionar(Paciente paciente) {
		try {
			String sql = "INSERT INTO TB_HF_PACIENTE (id_paciente, nm_nome_paciente, nm_rg_paciente, nr_cpf_paciente, nm_end_paciente, nm_email_paciente, nm_tel_paciente, fl_sexo_paciente, nm_tp_sang_paciente, nm_escolaridade_paciente) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement comandoDeInsercao = conexao.prepareStatement(sql);
			comandoDeInsercao.setLong(1, obterProximoIdPacientes());
			comandoDeInsercao.setString(2, paciente.getNome());
			comandoDeInsercao.setString(3, paciente.getRg());
			comandoDeInsercao.setInt(4, paciente.getCpf());
			comandoDeInsercao.setString(5, paciente.getEndereco());
			comandoDeInsercao.setString(6, paciente.getEmail());
			comandoDeInsercao.setString(7, paciente.getTelefone());
			comandoDeInsercao.setString(8, paciente.getSexo());
			comandoDeInsercao.setString(9, paciente.getTipoSangue());
			comandoDeInsercao.setString(10, paciente.getEscolaridade());
			comandoDeInsercao.execute();
			comandoDeInsercao.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	private Long obterProximoIdPacientes() {
		Long id = null;
		try {
			String sql = "SELECT SEQ_PACIENTES_ID.NEXTVAL FROM DUAL";
			PreparedStatement comandoDeGeracao = conexao.prepareStatement(sql);	
			ResultSet rs = comandoDeGeracao.executeQuery();
			while(rs.next()) {
				id = rs.getLong(1);
			}
			rs.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return id;
	}
	
	
	@Override
	public void fechar() {
		try {
			conexao.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
