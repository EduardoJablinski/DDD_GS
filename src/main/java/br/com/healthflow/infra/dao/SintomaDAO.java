package br.com.healthflow.infra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthflow.dominio.RepositorioSintomas;
import br.com.healthflow.dominio.Sintoma;

public class SintomaDAO implements RepositorioSintomas {

    private Connection conexao;

    public SintomaDAO() {
        conexao = new ConnectionFactory().getConnection();
    }

    @Override
    public void adicionar(Sintoma sintoma) {
        try {
            String sql = "INSERT INTO TB_HF_SINTOMAS (id_sintomas, sintoma) VALUES(?, ?)";
            PreparedStatement comandoDeInsercao = conexao.prepareStatement(sql);
            comandoDeInsercao.setLong(1, obterProximoIdSintoma());
            comandoDeInsercao.setString(2, sintoma.getNomeSintoma());
            comandoDeInsercao.execute();
            comandoDeInsercao.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Sintoma> obterTodos() {
        List<Sintoma> sintomas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM TB_HF_SINTOMAS";
            PreparedStatement comandoDeConsulta = conexao.prepareStatement(sql);
            ResultSet rs = comandoDeConsulta.executeQuery();
            while (rs.next()) {
                Sintoma sintoma = new Sintoma();
                sintoma.setId(rs.getLong("id_sintomas"));
                sintoma.setNomeSintoma(rs.getString("sintoma"));
                sintomas.add(sintoma);
            }
            rs.close();
            comandoDeConsulta.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sintomas;
    }

    private Long obterProximoIdSintoma() {
        Long id = null;
        try {
            String sql = "SELECT SEQ_SINTOMAS_ID.NEXTVAL FROM DUAL";
            PreparedStatement comandoDeGeracao = conexao.prepareStatement(sql);
            ResultSet rs = comandoDeGeracao.executeQuery();
            while (rs.next()) {
                id = rs.getLong(1);
            }
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    @Override
    public void fechar() {
        try {
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
