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

	public void cadastrarUsuario(Usuario usuario) {

		UsuarioDao dao = new UsuarioDao();
		dao.adicionar(usuario);

		FacesMessage fm = new FacesMessage("Usuário cadastrado!");
		FacesContext.getCurrentInstance().addMessage("Cadastro", fm);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
