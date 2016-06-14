package br.com.amigosecreto.mb;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.amigosecreto.dao.UsuarioDao;
import br.com.amigosecreto.entity.Usuario;

@SessionScoped
@ManagedBean
public class SorteioMB {

	private Usuario usuario;

	 public SorteioMB() {
		 ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		 Map<String, Object> sessionMap = externalContext.getSessionMap();
		 usuario = (Usuario) sessionMap.get("usuario_logado");
	}
	
	public void sortearAmigoSecreto() {
		
		UsuarioDao dao = new UsuarioDao();
		Set<Usuario> amigos = dao.findAllFriendsSecret(usuario);
		Optional<Usuario> usua = amigos.stream().findAny();
		usuario.setAmigosSorteado(usua.get());

		usuario = dao.atualizar(usuario);

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
