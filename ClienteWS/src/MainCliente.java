
import java.util.List;
import javax.ws.rs.core.GenericType;
import model.GastoExtra;
import model.Insumo;
import model.Produto;
import ws.ClienteOrganic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PedroSchwarz
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClienteOrganic cliente = new ClienteOrganic();

        List<Produto> listaProdutos = cliente.getProdutos(
                new GenericType<List<Produto>>() {
        });
        for (Produto p : listaProdutos) {
            System.out.println("Produto: "+p.getNomeProduto() + " " + p.getQualidadeProduto() + " " + p.getQuantidadeProduto() + " " + p.getPrecoProduto() + " " + p.getMedidaProduto());
        }
            System.out.println("\n");
        List<Insumo> listaInsumos = cliente.getInsumos(
                new GenericType<List<Insumo>>() {
        });
        for (Insumo i : listaInsumos) {
            System.out.println("Insumo: "+i.getNomeInsumo() + " " + i.getQuantInsumo() + " " + i.getPrecoInsumo());
        }
            System.out.println("\n");
        List<GastoExtra> listaGastoExtras = cliente.getGastoExtras(
                new GenericType<List<GastoExtra>>() {
        });
        for (GastoExtra g : listaGastoExtras) {
            System.out.println("Gasto Extra: "+g.getNomeGastoExtra() + " " + g.getQuantGastoExtra() + " " + g.getPrecoGastoExtra());
        }

    }
}
