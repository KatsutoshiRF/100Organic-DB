/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * Jersey REST client generated for REST resource:OrganicWS [Organic]<br>
 * USAGE:
 * <pre>
 *        ClienteOrganic client = new ClienteOrganic();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author PedroSchwarz
 */
public class ClienteOrganic {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/100Organic-WS/webresources";

    public ClienteOrganic() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Organic");
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

//    public String getProdutos() throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("Produto/get");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
//    }
    public <T> T getProdutos(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Produto/get");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T buscarProduto(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Produto/get/{nomeproduto}");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

//    public String getGastoExtras() throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("Gasto Extra/get");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
//    }
    public <T> T getGastoExtras(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Gasto Extra/get");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

//    public String getInsumos() throws ClientErrorException {
//        WebTarget resource = webTarget;
//        resource = resource.path("Insumo/get");
//        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
//    }
    public <T> T getInsumos(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Insumo/get");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getRendimentoTotal(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Rendimento/get");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCustoTotal(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Custo/get");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getReceita(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("Receita/get");
        return resource.request(MediaType.APPLICATION_JSON).get(responseType);
    }

    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void close() {
        client.close();
    }

}
