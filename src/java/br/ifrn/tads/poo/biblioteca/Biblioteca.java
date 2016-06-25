/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca;

import br.ifrn.tads.poo.biblioteca.acervo.Apostila;
import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.acervo.Texto;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.util.List;
import java.util.Date;

/**
 *
 * @author pablopc
 */
public class Biblioteca {
    String nomeBiblioteca;
    
    Usuario usuario = new Usuario();
    Livro livro = new Livro();
    Apostila apostila = new Apostila();
    Texto texto = new Texto();
    
    public Biblioteca(String nomeBiblioteca) {
        
        this.nomeBiblioteca = nomeBiblioteca;
    }    
    
    public String getNomeBiblioteca() {
        return nomeBiblioteca;
    }

    public void setNomeBiblioteca(String nomeBiblioteca) {
        this.nomeBiblioteca = nomeBiblioteca;
    }
    
    double calcularValorMulta(Date dia){
        
        return 0;
    }
}
