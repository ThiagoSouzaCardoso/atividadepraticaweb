package br.com.amigosecreto.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.amigosecreto.dao.UsuarioDao;
import br.com.amigosecreto.entity.Usuario;

@SessionScoped
@ManagedBean
public class CadastroUsuarioMB {

	private Usuario usuario;
	
	public CadastroUsuarioMB() {
		usuario = new Usuario();
	}

	public void cadastrarUsuario() {
		UsuarioDao dao = new UsuarioDao();
		dao.adicionar(usuario);
		FacesMessage fm = new FacesMessage("Usu�rio cadastrado!");
		FacesContext.getCurrentInstance().addMessage("Cadastro", fm);
		this.usuario = new Usuario();
	}
	
	public String voltarLogin(){
		return "acesso?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
