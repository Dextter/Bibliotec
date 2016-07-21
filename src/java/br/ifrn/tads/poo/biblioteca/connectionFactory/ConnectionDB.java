/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pablopc
 */
public class ConnectionDB {    
     private static Connection con = null;
     
             private static final String driver  = "org.postgresql.Driver";
             private static final String url = "jdbc:postgresql://localhost:5432/bibliotec";
             private static final String usuario = "postgres";
             private static final String senha = "projetopoo";
             
     public static Statement getConnection() {        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, senha);   
            Statement stmt = con.createStatement();
            return stmt;
         } catch (ClassNotFoundException e) {
            e.printStackTrace();
         } catch (SQLException e){
             e.printStackTrace();
         }            
            return null;                                
     } 
}
