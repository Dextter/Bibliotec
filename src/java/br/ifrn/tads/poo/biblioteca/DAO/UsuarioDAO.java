/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablopc
 */
public class UsuarioDAO {
    private Connection cone; 
    
    public UsuarioDAO() throws ClassNotFoundException{
        this.cone =  new ConexaoBd().getConnection();
        System.out.println("Conexão realizada com sucesso");
        usuario = new Usuario();
    }
    
     public Usuario getUsuario(Usuario users){
        String sql = "SELECT * FROM login WHERE usuario = ? AND senha = ?";
        try (PreparedStatement ps = cone.prepareStatement(sql)) {
            ps.setString(1, users.getMatricula());
            ps.setString(2, users.getSenha());
            ResultSet result = ps.executeQuery();
                if(result.next()){
                    Usuario usuarioLogado = new Usuario();
                    usuarioLogado.setMatricula(users.getMatricula());
                    usuarioLogado.setSenha(users.getSenha());
                    usuarioLogado.setPermissao(result.getString("permissao"));
                    usuarioLogado.setNomes(result.getString("nome"));
                    
                    return usuarioLogado;  
                }
        }catch(SQLException e){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(cone != null){
                try {
                    cone.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Desconectado!");
            }
        }
        return null;
    }
     public boolean cadastrar(Usuario usu){
        String bd = "INSERT INTO login (nome, usuario, email, contato, senha, permissao)"
                + "VALUES(?,?,?,?,?,?)";
        try(PreparedStatement ps = cone.prepareStatement(bd)){
            ps.setString(1,usu.getNome());
            ps.setString(2,usu.getMatricula());
            ps.setString(3,usu.getEmail());
            ps.setString(4,usu.getContato());
            ps.setString(5,usu.getSenha());
            ps.setString(6,usu.getPermissao());                        
            int testar  = ps.executeUpdate();
            if(testar == 1){
                return true;                   
            }
        } catch(SQLException e){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
    }finally{
            if(cone!=null){
                try{
                    cone.close();
                }catch(SQLException ex){
                     Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,ex);
                }
                System.out.println("Desconectado!");
            }
        }
            return false;
     }
    
    public Usuario selecionarUsuario(Usuario usuario){
        String sqls = "SELECT * FROM login WHERE usuario = ?";         
        try (PreparedStatement pst = cone.prepareStatement(sqls)){             
            pst.setString(1, usuario.getMatricula());            
            ResultSet result = pst.executeQuery();
                if(result.next()){
                    System.out.println("entrou no if2");
                    Usuario usuarioEncontrado =  new Usuario();
                    usuarioEncontrado.setNome(result.getString("nome"));
                    usuarioEncontrado.setMatricula(result.getString("usuario"));
                    usuarioEncontrado.setSenha(result.getString("senha"));
                    usuarioEncontrado.setEmail(result.getString("email"));
                    usuarioEncontrado.setContato(result.getString("contato"));
                    usuarioEncontrado.setPermissao(result.getString("permissao"));
                    usuarioEncontrado.setIdUsuario(result.getInt("id_login"));                                                            
                    return usuarioEncontrado;
                }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(cone != null){
                try {
                    cone.close();
                    System.out.println("Desconectado");
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
       
        return null;
    }
    public boolean excluirLogin(Usuario user){
        String sql = "DELETE FROM login WHERE usuario = ?";                    
            try (PreparedStatement ps = cone.prepareStatement(sql)){
                ps.setString(1, user.getMatricula());                
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
    public boolean atualizarLogin(Usuario usuario){
        String sql = "UPDATE login SET usuario = ?, senha = ?, permissao = ?, nome = ?, contato = ?,"
                + " email = ? WHERE id_login = ?";
                    
                try (PreparedStatement ps = cone.prepareStatement(sql)){
                    ps.setString(1, usuario.getMatricula());
                    ps.setString(2, usuario.getSenha());
                    ps.setString(3, usuario.getPermissao());
                    ps.setString(4, usuario.getNome());
                    ps.setString(5, usuario.getContato());
                    ps.setString(6, usuario.getEmail());
                    ps.setInt(7, usuario.getIdUsuario());
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
