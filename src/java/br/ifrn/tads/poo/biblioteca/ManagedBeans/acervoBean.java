/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.ManagedBeans;

import br.ifrn.tads.poo.biblioteca.DAO.ItemAcervoDAO;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author pablopc
 */
@ManagedBean
public class acervoBean {
    private List<Livro> acervo;
    private ItemAcervoDAO acervoDao;

    public ItemAcervoDAO getAcervoDao() {
        return acervoDao;
    }

    public void setAcervoDao(ItemAcervoDAO acervoDao) {
        this.acervoDao = acervoDao;
    }

    public List<Livro> getAcervo() {
        return acervo;
    }

    public void setAcervo(List<Livro> acervo) {
        this.acervo = acervo;
    }
    
    public final void listarAcervo() throws ClassNotFoundException{        
        this.acervoDao = new ItemAcervoDAO();
        this.acervo = this.acervoDao.listarLivros();
        if(acervo != null){
            System.out.println("Lista vazia");
        }
    }
}
