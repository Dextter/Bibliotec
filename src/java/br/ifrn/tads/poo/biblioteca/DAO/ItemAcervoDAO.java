/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.DAO;

import br.ifrn.tads.poo.biblioteca.acervo.Apostila;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.acervo.Texto;
import br.ifrn.tads.poo.biblioteca.connectionFactory.ConnectionDB;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 20152014040023
 */
public class ItemAcervoDAO {
    private Connection cone; 
    private Statement stmt;
    
    public ItemAcervoDAO() throws ClassNotFoundException{
//        this.stmt = ConnectionDB.getConnection(); 
//        try {
//            stmt = cone.createStatement();
//        } catch (SQLException ex) {
//            Logger.getLogger(ItemAcervoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println("Deu Tudo Certo!");
    }
    
    public Texto selecionarTexto(Texto txt){
        String sqls = "SELECT * FROM acervo WHERE titulo = ?";         
        try (PreparedStatement pst = cone.prepareStatement(sqls)){                         
            ResultSet result = pst.executeQuery();
                if(result.next()){                    
                    Texto txtEncontrado = new Texto();
                    txtEncontrado.setTitulo(result.getString("titulo"));
                    txtEncontrado.setAutor(result.getString("autor"));                                        
                    return txtEncontrado;
                }
        } catch (SQLException ex) {
            Logger.getLogger(ItemAcervoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(cone != null){
                try {
                    cone.close();                    
                } catch (SQLException ex) {
                    Logger.getLogger(ItemAcervoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }       
        return null;
    }    
    
    public Apostila selecionarApostila(Apostila apostila){
        String sqls = "SELECT * FROM acervo WHERE titulo = ?";         
        try (PreparedStatement pst = cone.prepareStatement(sqls)){                         
            ResultSet result = pst.executeQuery();
                if(result.next()){                    
                    Apostila apostilaEncontrada = new Apostila();
                    apostilaEncontrada.setTitulo(result.getString("titulo"));
                    apostilaEncontrada.setAutor(result.getString("autor"));                                        
                    return apostilaEncontrada;
                }
        } catch (SQLException ex) {
            Logger.getLogger(ItemAcervoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(cone != null){
                try {
                    cone.close();                    
                } catch (SQLException ex) {
                    Logger.getLogger(ItemAcervoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }       
        return null;
    }    
    
    public Livro selecionarLivro(Livro livro){
        String sqls = "SELECT * FROM acervo WHERE titulo = ?";         
        try (PreparedStatement pst = cone.prepareStatement(sqls)){                         
            ResultSet result = pst.executeQuery();
                if(result.next()){                    
                    Livro livroEncontrado = new Livro();
                    livroEncontrado.setTitulo(result.getString("titulo"));
                    livroEncontrado.setAutor(result.getString("autor"));
                    livroEncontrado.setISBN(result.getString("ISBN")); 
                    livroEncontrado.setEdicao(result.getInt("edicao")); 
                    return livroEncontrado;
                }
        } catch (SQLException ex) {
            Logger.getLogger(ItemAcervoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(cone != null){
                try {
                    cone.close();                    
                } catch (SQLException ex) {
                    Logger.getLogger(ItemAcervoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }       
        return null;
    }   
    
    public List<Livro> listarLivros() throws SQLException{
        //String sqls = "SELECT * FROM livros";         
        List<Livro> lista = new ArrayList<>();
                
        Livro livro = new Livro();
        livro.setTitulo("Liv 1");
        livro.setAutor("Aut 1");
        livro.setISBN("1");
        livro.setEdicao(1);
        lista.add(livro);
        
        Livro livro2 = new Livro();
        livro2.setTitulo("liv 2");
        livro2.setAutor("Aut 2");
        livro2.setISBN("2");
        livro2.setEdicao(2);
        lista.add(livro2);
        
        Livro livro3 = new Livro();
        livro3.setTitulo("Liv 3");
        livro3.setAutor("Aut 3");
        livro3.setISBN("3");
        livro3.setEdicao(3);
        lista.add(livro3);
        
        Livro livro4 = new Livro();
        livro4.setTitulo("iv 4");
        livro4.setAutor("Aut 4");
        livro4.setISBN("4");
        livro4.setEdicao(4);
        lista.add(livro4);

        //Connection con = ConnectionDB.getConnection();        
        //    ResultSet result = stmt.executeQuery(sqls);
        //    try{
        //        while(result.next()){
        //            Livro livro = new Livro();
        //                livro.setISBN(result.getString("isbn_livro"));
        //                livro.setAutor(result.getString("autor_livro"));
        //                livro.setTitulo(result.getString("titulo_livro"));
        //                livro.setEdicao(result.getInt("edicao_livro"));                    
        //            lista.add(livro);                    
        //        }
        //} catch (SQLException ex) {
        //    Logger.getLogger(ItemAcervoDAO.class.getName()).log(Level.SEVERE, null, ex);
        //}         
        return lista;
    }
}
