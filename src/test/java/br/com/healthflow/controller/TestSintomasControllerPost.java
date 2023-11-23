package br.com.healthflow.controller;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.healthflow.controller.SintomasController;
import br.com.healthflow.dominio.Sintoma;
import br.com.healthflow.infra.dao.SintomaDAO;

public class TestSintomasControllerPost {

    private SintomasController sintomasController;
    private SintomaDAO sintomaDao;

    @Before
    public void setUp() {
        sintomaDao = new SintomaDAO();
        sintomasController = new SintomasController();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAdicionarSintoma() {
        Sintoma sintoma = new Sintoma("Dor de cabeça");

        Response response = sintomasController.adicionar(sintoma);

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

    }
}
