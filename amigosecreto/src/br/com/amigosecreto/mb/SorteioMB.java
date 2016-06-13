package br.com.amigosecreto.mb;

import java.util.Optional;
import java.util.Set;

import br.com.amigosecreto.dao.UsuarioDao;
import br.com.amigosecreto.entity.Usuario;

public class SorteioMB {

	private Usuario usuario;

	public void sortearAmigoSecreto(Usuario user) {

		UsuarioDao dao = new UsuarioDao();
		Set<Usuario> amigos = dao.findAllFriendsSecret(user);
		Optional<Usuario> usua = amigos.stream().findAny();
		user.setAmigosSorteado(usua.get());

		dao.atualizar(user);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
