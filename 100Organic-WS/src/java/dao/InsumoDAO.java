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
import model.Insumo;
import model.Produto;

/**
 *
 * @author Katsutoshi
 */
public class InsumoDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    public InsumoDAO()
    {
    
    }
    
    public boolean inserir(Insumo insumo)
    {
        String sql = "INSERT INTO insumo(nomeinsumo,quantinsumo,precoinsumo) VALUES(?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, insumo.getNomeInsumo());
            pst.setInt(2, insumo.getQuantInsumo());
            pst.setDouble(3, insumo.getPrecoInsumo());

            
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(InsumoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public List<Insumo> listar()
    {
         String sql = "SELECT * FROM insumo";
        List<Insumo> retorno = new ArrayList<Insumo>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Insumo item = new Insumo();
                item.setId(res.getLong("id"));
                item.setNomeInsumo(res.getString("nomeinsumo"));
                item.setQuantInsumo(res.getInt("quantinsumo"));
                item.setPrecoInsumo(res.getDouble("precoinsumo"));
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(InsumoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
 public List<Insumo> buscar(Insumo insumo) {
        String sql = "SELECT * FROM insumo where nomeinsumo=?";
        List<Insumo> retorno = new ArrayList<Insumo>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, insumo.getNomeInsumo());
            ResultSet res = pst.executeQuery();

           while(res.next())
            {
                Insumo item = new Insumo();
                item.setId(res.getLong("id"));
                item.setNomeInsumo(res.getString("nomeinsumo"));
                item.setQuantInsumo(res.getInt("quantinsumo"));
                item.setPrecoInsumo(res.getDouble("precoinsumo"));
                
                retorno.add(item);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;

    }


}
