/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;

/**
 *
 * @author Katsutoshi
 */
public class ProdutoDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    public ProdutoDAO()
    {
    
    }
    
    public boolean inserir(Produto produto)
    {
        String sql = "INSERT INTO produto(nomeproduto,medidaproduto,precoproduto,qualidadeproduto,quantidadeproduto) VALUES(?,?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, produto.getNomeProduto());
            pst.setString(2, produto.getMedidaProduto());
            pst.setDouble(3, produto.getPrecoProduto());
            pst.setString(4, produto.getQualidadeProduto());
            pst.setInt(5, produto.getQuantidadeProduto());
            
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    public List<Produto> listar()
    {
         String sql = "SELECT * FROM produto";
        List<Produto> retorno = new ArrayList<Produto>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Produto item = new Produto();
                item.setId(res.getLong("id"));
                item.setNomeProduto(res.getString("nomeproduto"));
                item.setQualidadeProduto(res.getString("qualidadeproduto"));
                item.setQuantidadeProduto(res.getInt("quantidadeproduto"));
                item.setMedidaProduto(res.getString("medidaproduto"));
                item.setPrecoProduto(res.getDouble("precoproduto"));
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
 public List<Produto> buscar(Produto produto) {
        String sql = "SELECT * FROM produto where nomeproduto=?";
        List<Produto> retorno = new ArrayList<Produto>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, produto.getNomeProduto());
            ResultSet res = pst.executeQuery();

           while (res.next()) {
                Produto item = new Produto();
                item.setId(res.getLong("id"));
                item.setNomeProduto(res.getString("nomeproduto"));
                item.setQualidadeProduto(res.getString("qualidadeproduto"));
                item.setQuantidadeProduto(res.getInt("quantidadeproduto"));
                item.setMedidaProduto(res.getString("medidaproduto"));
                item.setPrecoProduto(res.getDouble("precoproduto"));

                retorno.add(item);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;

    }


}
