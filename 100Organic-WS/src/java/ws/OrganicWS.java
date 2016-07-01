/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.GastoExtraDAO;
import dao.InsumoDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.GastoExtra;
import model.Insumo;
import model.Produto;

/**
 * REST Web Service
 *
 * @author Katsutoshi
 */
@Path("Organic")
public class OrganicWS {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OrganicWS
     */
    public OrganicWS() {
    }

    /**
     * Retrieves representation of an instance of ws.OrganicWS
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Produces("application/json")
    @Path("Produto/get")
    public String getProdutos() {
        List<Produto> lista = new ArrayList<Produto>();
        ProdutoDAO dao = new ProdutoDAO();
        lista = dao.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @GET
    @Produces("application/json")
    @Path("Insumo/get")
    public String getInsumos() {
        List<Insumo> lista = new ArrayList<Insumo>();
        InsumoDAO dao = new InsumoDAO();
        lista = dao.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @GET
    @Produces("application/json")
    @Path("Gasto Extra/get")
    public String getGastoExtras() {
        List<GastoExtra> lista = new ArrayList<GastoExtra>();
        GastoExtraDAO dao = new GastoExtraDAO();
        lista = dao.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    }

    /**
     * PUT method for updating or creating an instance of OrganicWS
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
