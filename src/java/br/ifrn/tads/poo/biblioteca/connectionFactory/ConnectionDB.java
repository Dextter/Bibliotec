/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.connectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pablopc
 */
public class ConnectionDB {    
     private String url = "jdbc:postgresql://localhost:5432/bibliotec", user = "postgres", password = "euamoNathalia";
     public Connection getConnection() throws ClassNotFoundException {
         try{              
             Class.forName("org.postgresql.Driver");
             return DriverManager.getConnection(url,user,password);            
         }catch(SQLException e){             
             throw new RuntimeException(e);             
         }
     }
}
