package br.com.healthflow.controller;

import br.com.healthflow.dominio.Sintoma;
import br.com.healthflow.infra.dao.SintomaDAO;
import br.com.healthflow.controller.SintomasController;

public class TestSintomasControllerGet {

    public static void main(String[] args) {
        Sintoma sintomaTeste = new Sintoma("Dor de Cabeça");

        SintomasController sintomasController = new SintomasController();
        SintomaDAO sintomaDao = new SintomaDAO();

        try {
            sintomasController.adicionar(sintomaTeste);

            System.out.println("Sintoma adicionado com sucesso!");

        } catch (Exception e) {
            System.err.println("Erro ao adicionar sintoma: " + e.getMessage());
        } finally {
            sintomaDao.fechar();
        }
    }
}
