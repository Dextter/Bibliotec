/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.DAO;

import br.ifrn.tads.poo.biblioteca.connectionFactory.ConnectionDB;
import br.ifrn.tads.poo.biblioteca.usuario.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablopc
 */
public class AdministradorDAO {
    private Connection cone; 
    private Statement stmt; 
    
    public AdministradorDAO() throws ClassNotFoundException{
        this.stmt =  ConnectionDB.getConnection();        
        Administrador admin = new Administrador();
    }
    
     public Administrador getUsuario(Administrador users){
        String sql = "SELECT * FROM login WHERE usuario = ? AND senha = ?";
        try (PreparedStatement ps = cone.prepareStatement(sql)) {
            ps.setInt(1, users.getCodUsuario());
            ps.setString(2, users.getSenha());
            ResultSet result = ps.executeQuery();
                if(result.next()){
                    Administrador usuarioLogado = new Administrador();
                    usuarioLogado.setCodUsuario(users.getCodUsuario());
                    usuarioLogado.setSenha(users.getSenha());                    
                    usuarioLogado.setNome(result.getString("nome"));
                    
                    return usuarioLogado;  
                }
        }catch(SQLException e){
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(cone != null){
                try {
                    cone.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
        }
        return null;
    }
     public boolean cadastrar(Administrador usu){
        String bd = "INSERT INTO login (nome, CodUsuario, senha, cpf, endereco)"
                + "VALUES(?,?,?,?,?)";
        try(PreparedStatement ps = cone.prepareStatement(bd)){
            ps.setString(1,usu.getNome());
            ps.setInt(2,usu.getCodUsuario());
            ps.setString(3,usu.getSenha());
            ps.setString(4,usu.getSenha());
            ps.setString(5,usu.getCpf());
            ps.setString(6,usu.getEndereco());                        
            int testar  = ps.executeUpdate();
            if(testar == 1){
                return true;                   
            }
        } catch(SQLException e){
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE,null,e);
    }finally{
            if(cone!=null){
                try{
                    cone.close();
                }catch(SQLException ex){
                     Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE,null,ex);
                }                
            }
        }
            return false;
     }
    
    public Administrador selecionarUsuario(Administrador usuario){
        String sqls = "SELECT * FROM login WHERE usuario = ?";         
        try (PreparedStatement pst = cone.prepareStatement(sqls)){             
            pst.setInt(1, usuario.getCodUsuario());            
            ResultSet result = pst.executeQuery();
                if(result.next()){                    
                    Administrador usuarioEncontrado =  new Administrador();
                    usuarioEncontrado.setNome(result.getString("nome"));
                    usuarioEncontrado.setCodUsuario(result.getInt("CodUsuario"));
                    usuarioEncontrado.setSenha(result.getString("senha"));
                    usuarioEncontrado.setCpf(result.getString("cpf"));
                    usuarioEncontrado.setEndereco(result.getString("endereco"));                                                                               
                    return usuarioEncontrado;
                }
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(cone != null){
                try {
                    cone.close();                    
                } catch (SQLException ex) {
                    Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
        return null;
    }
    public boolean excluirLogin(Administrador user){
        String sql = "DELETE FROM login WHERE usuario = ?";                    
            try (PreparedStatement ps = cone.prepareStatement(sql)){
                ps.setInt(1, user.getCodUsuario());                
                int retorno = ps.executeUpdate();                    
                        if(retorno == 1){                            
                            return true;
                        }
            } catch (SQLException ex) {
                        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                    if(cone != null){
                        try {
                            cone.close();                            
                        } catch (SQLException ex) {
                            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
       
        return false;
    }
    public boolean atualizarLogin(Administrador usuario){
        String sql = "UPDATE login SET usuario = ?, senha = ?, permissao = ?, nome = ?, contato = ?,"
                + " email = ? WHERE id_login = ?";
                    
                try (PreparedStatement ps = cone.prepareStatement(sql)){
                    ps.setInt(1, usuario.getCodUsuario());
                    ps.setString(2, usuario.getSenha());                    
                    ps.setString(4, usuario.getNome());
                    ps.setString(5, usuario.getEndereco());
                    ps.setString(6, usuario.getSenha());                    
                    int retornos = ps.executeUpdate();
                        if(retornos == 1){
                                return true;
                        }
                } catch (SQLException ex) {
                        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    if(cone != null){
                        try {
                            cone.close();                            
                        } catch (SQLException ex) {
                            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }       
        return false;
    }
}
