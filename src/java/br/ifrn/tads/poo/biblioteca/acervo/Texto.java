/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.acervo;

import java.util.Date;

/**
 *
 * @author pablopc
 */
public class Texto extends ItemAcervo{
    String autor, titulo, quantidade;
    boolean alugado;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }   

    public String getTitulo() {
        return titulo;
    }        
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Texto(double custo, int codigoItem, boolean pago, Date dataAluguel, Date dataDevolucao) {
        super(custo, codigoItem, pago, dataAluguel, dataDevolucao);
    }
    
    public Texto(){}

    @Override
    public void alugar() {
        //para cada titulo de livro igual ao desejado itere uma lista com todos os livros com este nome
        
        //subtraia 1 desta lista
    }
    
    @Override
    public double devolver() {
        return 0;
    }

    @Override
    public boolean estaPago() {
        return true;
    }

    @Override
    public void reservar() {
        
    }
}
