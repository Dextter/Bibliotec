/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.ManagedBeans;

import br.ifrn.tads.poo.biblioteca.DAO.ItemAcervoDAO;
import br.ifrn.tads.poo.biblioteca.acervo.Apostila;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.acervo.Texto;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author pablopc
 */
@ManagedBean
public class acervoBean {
    private List<Livro> livros;
    private List<Apostila> apostilas;
    private List<Texto> textos;
    private ItemAcervoDAO acervo;

    public List<Livro> getLivros() throws ClassNotFoundException, SQLException {        
        listarAcervo();
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Apostila> getApostilas() {
        return apostilas;
    }

    public void setApostilas(List<Apostila> apostilas) {
        this.apostilas = apostilas;
    }

    public List<Texto> getTextos() {
        return textos;
    }

    public void setTextos(List<Texto> textos) {
        this.textos = textos;
    }

    public ItemAcervoDAO getAcervo() {
        return acervo;
    }

    public void setAcervo(ItemAcervoDAO acervo) {
        this.acervo = acervo;
    }
    
    public List<Livro> listarAcervo() throws ClassNotFoundException, SQLException{        
        ItemAcervoDAO acervo = new ItemAcervoDAO();
        this.livros = acervo.listarLivros();         
        if(livros == null){
            System.out.println("Lista de livros vazia");
        }
        return livros;
    }
}
