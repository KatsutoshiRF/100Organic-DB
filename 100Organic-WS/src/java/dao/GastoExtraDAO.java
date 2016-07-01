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
import model.GastoExtra;
import model.Produto;

/**
 *
 * @author Katsutoshi
 */
public class GastoExtraDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    public GastoExtraDAO()
    {
    
    }
    
    public boolean inserir(GastoExtra gastoExtra)
    {
        String sql = "INSERT INTO gastoextra(nomegastoextra,precogastoextra,quantgastoextra) VALUES(?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, gastoExtra.getNomeGastoExtra());
            pst.setInt(2, gastoExtra.getQuantGastoExtra());
            pst.setDouble(3, gastoExtra.getPrecoGastoExtra());
            
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GastoExtraDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public List<GastoExtra> listar()
    {
         String sql = "SELECT * FROM gastoextra";
        List<GastoExtra> retorno = new ArrayList<GastoExtra>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                GastoExtra item = new GastoExtra();
                item.setId(res.getLong("id"));
                item.setNomeGastoExtra(res.getString("nomegastoextra"));
                item.setQuantGastoExtra(res.getInt("quantgastoextra"));
                item.setPrecoGastoExtra(res.getDouble("precogastoextra"));
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GastoExtraDAO.class.getName()).log(Level.SEVERE, null, ex);
            
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
