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
import javax.ws.rs.PathParam;
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

    public OrganicWS() {
    }

    @GET
    @Produces("application/json")
    @Path("Rendimento/get")
    public String getRendimentoTotal() {
        List<Produto> lista = new ArrayList<Produto>();
        ProdutoDAO dao = new ProdutoDAO();
        lista = dao.listar();
        double valorTotal = 0;
        for (int i = 0; i < lista.size(); i++) {
            double valor = lista.get(i).getPrecoProduto() * lista.get(i).getQuantidadeProduto();
            valorTotal += valor;
        }
        Gson g = new Gson();
        return g.toJson(valorTotal);
    }

    @GET
    @Produces("application/json")
    @Path("Custo/get")
    public String getCustoTotal() {
        List<Insumo> lista = new ArrayList<Insumo>();
        InsumoDAO dao = new InsumoDAO();
        lista = dao.listar();
        double valorTotal = 0;
        for (int i = 0; i < lista.size(); i++) {
            double valor = lista.get(i).getPrecoInsumo() * lista.get(i).getQuantInsumo();
            valorTotal += valor;
        }
        List<GastoExtra> lista2 = new ArrayList<GastoExtra>();
        GastoExtraDAO dao2 = new GastoExtraDAO();
        lista2 = dao2.listar();
        for (int i = 0; i < lista2.size(); i++) {
            double valor = lista2.get(i).getPrecoGastoExtra()* lista2.get(i).getQuantGastoExtra();
            valorTotal += valor;
        }
        Gson g = new Gson();
        return g.toJson(valorTotal);
    }
        @GET
    @Produces("application/json")
    @Path("Receita/get")
    public String getReceita() {
        String receita= "";
        List<Insumo> lista = new ArrayList<Insumo>();
        InsumoDAO dao = new InsumoDAO();
        lista = dao.listar();
        double valorTotal = 0;
        for (int i = 0; i < lista.size(); i++) {
            double valor = lista.get(i).getPrecoInsumo() * lista.get(i).getQuantInsumo();
            valorTotal += valor;
        }
        List<GastoExtra> lista2 = new ArrayList<GastoExtra>();
        GastoExtraDAO dao2 = new GastoExtraDAO();
        lista2 = dao2.listar();
        for (int i = 0; i < lista2.size(); i++) {
            double valor = lista2.get(i).getPrecoGastoExtra() * lista2.get(i).getQuantGastoExtra();
            valorTotal += valor;
        }

        List<Produto> lista3 = new ArrayList<Produto>();
        ProdutoDAO dao3 = new ProdutoDAO();
        lista3 = dao3.listar();
        double valorTotal2 = 0;
        for (int i = 0; i < lista3.size(); i++) {
            double valor = lista3.get(i).getPrecoProduto() * lista3.get(i).getQuantidadeProduto();
            valorTotal2 += valor;
        }
        if((valorTotal2-valorTotal)<0){
        receita ="Receita com rendimentos no vermelho de ["+(valorTotal2-valorTotal)+"]";
        }
        else {
        receita = "Rendimento de [" +(valorTotal2-valorTotal)+"]" ;}
        Gson g = new Gson();
        return g.toJson(receita);
    }
    

    /*----Metodos de Listagem----*/
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

    /*----Metodos de Procura por Nome----*/
    @GET
    @Produces("application/json")
    @Path("Produto/get/{nomeproduto}")
    public String getProdutobyName(@PathParam("nomeproduto") String nome) {
        Produto produto = new Produto();
        produto.setNomeProduto(nome);
        List<Produto> lista = new ArrayList<Produto>();
        ProdutoDAO dao = new ProdutoDAO();
        lista = dao.buscar(produto);
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @GET
    @Produces("application/json")
    @Path("Gasto Extra/get/{nomegastoextra}")
    public String getGastoExtrabyName(@PathParam("nomegastoextra") String nome) {
        GastoExtra gasto = new GastoExtra();
        gasto.setNomeGastoExtra(nome);
        List<GastoExtra> lista = new ArrayList<GastoExtra>();
        GastoExtraDAO dao = new GastoExtraDAO();
        lista = dao.buscar(gasto);
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @GET
    @Produces("application/json")
    @Path("Insumo/get/{nomeinsumo}")
    public String getInsumobyName(@PathParam("nomeinsumo") String nome) {
        Insumo insumo = new Insumo();
        insumo.setNomeInsumo(nome);
        List<Insumo> lista = new ArrayList<Insumo>();
        InsumoDAO dao = new InsumoDAO();
        lista = dao.buscar(insumo);
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
