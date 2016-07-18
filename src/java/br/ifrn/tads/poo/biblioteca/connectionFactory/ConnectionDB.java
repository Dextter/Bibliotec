/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.connectionFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pablopc
 */
public class ConnectionDB {
    private String driver = "org.postgresql.Driver";
     private String url = "jdbc:postgresql://localhost/bibliotec", user = "postgres", password = "euamoNathalia";
     public java.sql.Connection getConnection() throws ClassNotFoundException{
         try{
              System.out.println("conectou");
             Class.forName(driver);
             return DriverManager.getConnection(url,user,password);            
         }catch(SQLException e){
             System.out.println(" nao conectou");
             throw new RuntimeException(e);
             
         }
     }
}
