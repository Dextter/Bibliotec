/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifrn.tads.poo.biblioteca.ManagedBeans;

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
     
    public AdministradorBean() {
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
            this.bibliotecario = this.bibliotecariodao.getAdministrador(this.bibliotecario);
            if(!"ADMINISTRADOR".equals(this.bibliotecario.getPermissao())){                
                return "trabalhos";
            }else{
                return "Admin";
               
            }
        }catch(ClassNotFoundException ex){
             Logger.getLogger(BeanLogar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
    public void cadastro(){         
        try {
            this.bibliotecariodao = new AdministradorDAO();                                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BibliotecarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }this.bibliotecario = new Bibliotecario();
       }
    public void clicarBotaoCadastraSessao() {
        addMessage("Sucesso!", "Usuário cadastrado com sucesso.");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     public void clicarBotaoPesquisa() {
//        addMessage("Sucesso!", "Usuário encontrado.");
    }
      public void selecionarUsuario(){
          System.out.println("entrou no mb");
          try{
              System.out.println("ENTROU NO TRY");
             
              this.bibliotecariodao = new BibliotecarioDAO();
              this.bibliotecario = this.bibliotecariodao.selecionaUsuario(this.bibliotecario);
              if(bibliotecario != null){
                  System.out.println("entrou no if");
                FacesMessage mensagem = new FacesMessage("Usuário encontrado"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
              }
              else{
                FacesMessage mensagem = new FacesMessage("Usuário não encontrado"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
              }
          }catch (ClassNotFoundException ex) {
            Logger.getLogger(BibliotecarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void excluiLogin(){
        System.out.println("entrou no método para excluir no mb " + this.bibliotecario.getMatricula());
        
        try {
            this.bibliotecariodao = new BibliotecarioDAO();
            boolean excluirLogin = this.bibliotecariodao.excluiLogin(this.bibliotecario);
            System.out.println("chamou método exclui no mb");
            if(excluirLogin){
                //this.paciente.setMostrapesquisa(false);
                System.out.println("retornou pro mb como excluido");
                FacesMessage mensagem = new FacesMessage("Usuario excluído"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
            }else{
                FacesMessage mensagem = new FacesMessage("Falha na exclusão"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BibliotecarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.bibliotecario = new Bibliotecario();
    }
      public void alteraLogin(){
        System.out.println("entrou no método alterar do mb");
        try {
            
            this.bibliotecariodao = new BibliotecarioDAO();
            boolean alteraLogin = this.bibliotecariodao.atualizaLogin(this.bibliotecario);
            if(alteraLogin){
//                System.out.println("estado do mostra pesqusia antes: " + this.paciente.isMostrapesquisa());
//                this.paciente.setMostrapesquisa(false);
//                System.out.println("estado do mostra pesqusia depois: " + this.paciente.isMostrapesquisa());
                FacesMessage mensagem = new FacesMessage("Usuario alterado"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
            }else{
                FacesMessage mensagem = new FacesMessage("Falha na alteração"); 
                FacesContext.getCurrentInstance().addMessage(null, mensagem);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(BibliotecarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.bibliotecario = new Bibliotecario();
    }
      public void limpar(){
          System.out.println("entru no mb");
         this.bibliotecario = new Bibliotecario();
        
         
         
      }
      public String logout(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "index";
    }
    
}
