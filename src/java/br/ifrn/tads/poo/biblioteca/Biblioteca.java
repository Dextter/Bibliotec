/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.util.List;

/**
 *
 * @author pablopc
 */
public class Biblioteca {
    String nomeBiblioteca;
    
    List<Usuario> usuarios;    
    List<ItemAcervo> itens;
    
    
    public Biblioteca(String nomeBiblioteca) {
        
        this.nomeBiblioteca = nomeBiblioteca;
    }    
    
    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }
    
    double calcularValorMulta(){
        return 0;
    }
}
