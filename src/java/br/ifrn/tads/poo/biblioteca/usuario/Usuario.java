/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.usuario;
import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
/**
 *
 * @author pablopc
 */
public class Usuario {
    int codUsuario;
    String nome, endereco, cpf;
    
    ItemAcervo item;

    public Usuario(int codUsuario, String nome, String endereco, String cpf) {
        this.codUsuario = codUsuario;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
    }
    
    
    void pagar(){
    
    }
    
    ItemAcervo escolherItemAcervo(){
        return null;
    }
}
