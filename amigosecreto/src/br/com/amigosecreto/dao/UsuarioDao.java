package br.com.amigosecreto.dao;

import java.util.Set;

public class UsuarioDao extends GenericDao<Usuario> implements Dao<Usuario>{

	public UsuarioDao() {
		super(Usuario.class);
	} 

	public Set<Usuario> findAllFriendsSecret(Usuario usuario){
		
		return null;
	}
	
}
