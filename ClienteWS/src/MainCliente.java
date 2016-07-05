
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
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

    static ClienteOrganic cliente = new ClienteOrganic();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        produtos();
        insumos();
        gastoExtras();
        rendimentoTotal();
        custoTotal();
        receita();
    }

    public static void produtos() {
        String aux = "";
        List<Produto> listaProdutos = cliente.getProdutos(
                new GenericType<List<Produto>>() {
        });

        for (Produto p : listaProdutos) {
            aux += "\nProduto: " + p.getNomeProduto() + " " + p.getQualidadeProduto() + " " + p.getQuantidadeProduto() + " " + p.getPrecoProduto() + " " + p.getMedidaProduto();
            System.out.println("Produto: " + p.getNomeProduto() + " " + p.getQualidadeProduto() + " " + p.getQuantidadeProduto() + " " + p.getPrecoProduto() + " " + p.getMedidaProduto());
        }
        JOptionPane.showMessageDialog(null, aux);
        System.out.println("\n");
    }

    public static void insumos() {
        String aux = "";
        List<Insumo> listaInsumos = cliente.getInsumos(
                new GenericType<List<Insumo>>() {
        });
        for (Insumo i : listaInsumos) {
            System.out.println("Insumo: " + i.getNomeInsumo() + " " + i.getQuantInsumo() + " " + i.getPrecoInsumo());
            aux += "\nInsumo: " + i.getNomeInsumo() + " " + i.getQuantInsumo() + " " + i.getPrecoInsumo();
        }
        JOptionPane.showMessageDialog(null, aux);
        System.out.println("\n");
    }

    public static void gastoExtras() {
        String aux = "";
        List<GastoExtra> listaGastoExtras = cliente.getGastoExtras(
                new GenericType<List<GastoExtra>>() {
        });
        for (GastoExtra g : listaGastoExtras) {
            System.out.println("Gasto Extra: " + g.getNomeGastoExtra() + " " + g.getQuantGastoExtra() + " " + g.getPrecoGastoExtra());
            aux += "\nGasto Extra: " + g.getNomeGastoExtra() + " " + g.getQuantGastoExtra() + " " + g.getPrecoGastoExtra();
        }
        JOptionPane.showMessageDialog(null, aux);
        System.out.println("\n");
    }

    public static void rendimentoTotal() {
        List<Produto> lista = cliente.getProdutos(
                new GenericType<List<Produto>>() {
        });
        double valorTotal = 0;
        for (int i = 0; i < lista.size(); i++) {
            double valor = lista.get(i).getPrecoProduto() * lista.get(i).getQuantidadeProduto();
            valorTotal += valor;
        }
        JOptionPane.showMessageDialog(null, valorTotal);
        System.out.println("\n");
    }

    public static void custoTotal() {
        List<Insumo> lista = cliente.getInsumos(
                new GenericType<List<Insumo>>() {
        });
        double valorTotal = 0;
        for (int i = 0; i < lista.size(); i++) {
            double valor = lista.get(i).getPrecoInsumo() * lista.get(i).getQuantInsumo();
            valorTotal += valor;
        }
        List<GastoExtra> lista2 = cliente.getGastoExtras(
                new GenericType<List<GastoExtra>>() {
        });
        for (int i = 0; i < lista2.size(); i++) {
            double valor = lista2.get(i).getPrecoGastoExtra() * lista2.get(i).getQuantGastoExtra();
            valorTotal += valor;
        }
        JOptionPane.showMessageDialog(null, valorTotal);
        System.out.println("\n");
    }
    
    public static void receita(){
            String receita= "";
        List<Insumo> lista = cliente.getInsumos(
                new GenericType<List<Insumo>>() {
        });
        double valorTotal = 0;
        for (int i = 0; i < lista.size(); i++) {
            double valor = lista.get(i).getPrecoInsumo() * lista.get(i).getQuantInsumo();
            valorTotal += valor;
        }
        List<GastoExtra> lista2 = cliente.getGastoExtras(
                new GenericType<List<GastoExtra>>() {
        });
        for (int i = 0; i < lista2.size(); i++) {
            double valor = lista2.get(i).getPrecoGastoExtra() * lista2.get(i).getQuantGastoExtra();
            valorTotal += valor;
        }

        List<Produto> lista3 = cliente.getProdutos(
                new GenericType<List<Produto>>() {
        });
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
        JOptionPane.showMessageDialog(null, receita);
    }
}
