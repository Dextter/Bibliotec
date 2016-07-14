/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.ManagedBeans;

import br.ifrn.tads.poo.biblioteca.DAO.AdministradorDAO;
import br.ifrn.tads.poo.biblioteca.usuario.Administrador;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pablopc
 */
public class BeanLogar {
    
    private Administrador bibliotecario;
    private AdministradorDAO bibliotecariodao;
     
    public BeanLogar() {
        this.bibliotecario = new Administrador();
    }

    public Administrador getAdministrador() {
        return bibliotecario;
    }

    public void setAdministrador(Administrador bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public AdministradorDAO getAdministradorDao() {
        return bibliotecariodao;
    }

    public void setAdministradorDao(AdministradorDAO bibliotecariodao) {
        this.bibliotecariodao = bibliotecariodao;
    }
    
  
    
    public String logar(){        
        try{
            this.bibliotecariodao = new AdministradorDAO();
            this.bibliotecario = this.bibliotecariodao.getUsuario(bibliotecario);
            if("Administrador".equals(bibliotecario)){                                            
                return "Admin";               
            } else {
                return "index";
            }
        }catch(ClassNotFoundException ex){
             Logger.getLogger(BeanLogar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
    public void cadastrar(){         
        try {
            this.bibliotecariodao = new AdministradorDAO();                                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanLogar.class.getName()).log(Level.SEVERE, null, ex);
        }this.bibliotecario = new Administrador();
       }
    public void clicarBotaoCadastraSessao() {
        addMessage("Sucesso!", "Usuário cadastrado com sucesso.");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void clicarBotaoPesquisa() {
        addMessage("Sucesso!", "Usuário encontrado.");
    }
    public void selecionarUsuario(){          
        try{                           
            this.bibliotecariodao = new AdministradorDAO();
            this.bibliotecario = this.bibliotecariodao.selecionarUsuario(this.bibliotecario);
            if(bibliotecario != null){                  
                FacesMessage mensagem = new FacesMessage("Usuário encontrado"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
            }
            else{
                FacesMessage mensagem = new FacesMessage("Usuário não encontrado"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
              }
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanLogar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void excluiLogin(){
        System.out.println(this.bibliotecario.getCodUsuario());
        
        try {
            this.bibliotecariodao = new AdministradorDAO();
            boolean excluirLogin = this.bibliotecariodao.excluirLogin(this.bibliotecario);            
            if(excluirLogin){                                ;
                FacesMessage mensagem = new FacesMessage("Usuario excluído"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
            }else{
                FacesMessage mensagem = new FacesMessage("Falha na exclusão"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BeanLogar.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.bibliotecario = new Administrador();
    }
      public void alteraLogin(){        
        try {
            this.bibliotecariodao = new AdministradorDAO();
            boolean alterarLogin = this.bibliotecariodao.atualizarLogin(this.bibliotecario);
            if(alterarLogin){
                FacesMessage mensagem = new FacesMessage("Usuario alterado"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
            }else{
                FacesMessage mensagem = new FacesMessage("Falha na alteração"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.bibliotecario = new Administrador();
    }
    public void limpar(){          
        this.bibliotecario = new Administrador();
        
         
         
    }
    public String logout(){
       HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
       session.invalidate();
       return "index";
    }
    
}
