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
public class ItemAcervo {
    double custo;
    int codigoItem;
    boolean pago;
    Date dataAluguel, dataDevolucao;

    public ItemAcervo(double custo, int codigoItem, boolean pago, Date dataAluguel, Date dataDevolucao) {
        this.custo = custo;
        this.codigoItem = codigoItem;
        this.pago = pago;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
    }
    
    void alugar(){
        
    }
    
    double devolver(){
        return 0;
    }
    
    boolean estaPago(){
        return true;
     }
    
    void reservar(){
    
    }
}
