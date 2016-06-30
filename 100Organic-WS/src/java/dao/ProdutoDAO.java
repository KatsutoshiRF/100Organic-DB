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
//    public boolean atualizar(Usuario usuario)
//    {
//        String sql = "UPDATE usuario set senha=?,perfil=?,email=? where login=?";
//        Boolean retorno = false;
//        PreparedStatement pst = Conexao.getPreparedStatement(sql);
//        try {
//          
//            pst.setString(1, usuario.getSenha());
//            pst.setString(2, usuario.getPerfil());
//            pst.setString(3, usuario.getEmail());
//            pst.setString(4, usuario.getLogin());
//            if(pst.executeUpdate()>0)
//            {
//                retorno = true;
//            }
//                
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            retorno = false;
//        }
//        
//        return retorno;
//    
//    }
//    public boolean excluir(Usuario usuario)
//    {
//        String sql = "DELETE FROM usuario where login=?";
//        Boolean retorno = false;
//        PreparedStatement pst = Conexao.getPreparedStatement(sql);
//        try {
//          
//           
//            pst.setString(1, usuario.getLogin());
//            if(pst.executeUpdate()>0)
//            {
//                retorno = true;
//            }
//                
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            retorno = false;
//        }
//        
//        return retorno;
//    
//    }
    
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
//    public Usuario buscar(Usuario usuario)
//    {
//         String sql = "SELECT * FROM usuario where login=?";
//        Usuario retorno = null;
//        
//        PreparedStatement pst = Conexao.getPreparedStatement(sql);
//        try {
//           
//            pst.setString(1, usuario.getLogin());
//            ResultSet res = pst.executeQuery();
//            
//            if(res.next())
//            {
//                retorno = new Usuario();
//                retorno.setLogin(res.getString("login"));
//                retorno.setSenha(res.getString("senha"));
//                retorno.setEmail(res.getString("email"));
//                retorno.setPerfil(res.getString("perfil"));
//                
//                
//            }
//               
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//            
//        }
//        
//        return retorno;
//    
//    
//    }


}
