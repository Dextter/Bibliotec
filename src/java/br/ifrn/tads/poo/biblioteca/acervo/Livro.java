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
public class Livro extends ItemAcervo{
    String ISBN, autor, titulo;
    int quantidade;
    Integer edicao;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getEdicao() {
        return edicao;
    }

    public void setEdicao(Integer edicao) {
        this.edicao = edicao;
    }

    public Livro(double custo, int codigoItem, boolean pago, Date dataAluguel, Date dataDevolucao) {
        super(custo, codigoItem, pago, dataAluguel, dataDevolucao);
    }
    
    public Livro(){}
    
    @Override
    public void alugar() {
        
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
