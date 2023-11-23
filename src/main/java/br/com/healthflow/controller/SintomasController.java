package br.com.healthflow.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.healthflow.dominio.Sintoma;
import br.com.healthflow.infra.dao.SintomaDAO;

@Path("sintomas")
public class SintomasController {

    public SintomaDAO sintomaDao;

    public SintomasController() {
        sintomaDao = new SintomaDAO();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response adicionar(Sintoma sintoma) {
        sintomaDao.adicionar(sintoma);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sintoma> obterTodos() {
        List<Sintoma> sintomas = sintomaDao.obterTodos();
        return sintomas;
    }
}



