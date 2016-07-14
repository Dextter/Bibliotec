/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.usuario;

/**
 *
 * @author pablopc
 */
public class Administrador extends Usuario {
    
    public Administrador(int codUsuario, boolean ativo, String nome, String endereco, String cpf) {
        super(codUsuario, ativo, nome, endereco, cpf);
    }            

    public Administrador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
