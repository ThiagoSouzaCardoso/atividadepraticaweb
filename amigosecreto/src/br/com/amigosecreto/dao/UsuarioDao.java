package br.com.amigosecreto.dao;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Query;

import br.com.amigosecreto.dao.util.JpaUtil;
import br.com.amigosecreto.entity.Usuario;

public class UsuarioDao extends GenericDao<Usuario> implements Dao<Usuario>{

	public UsuarioDao() {
		super(Usuario.class);
	} 

	public Set<Usuario> findAllFriendsSecret(Usuario usuario){
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		String jpql = "from Usuario user where user.amigosSorteado is null and user.cpf <> :pCPF";
		Query query = em.createQuery(jpql);
		query.setParameter("pCPF", usuario.getCpf());
		List<Usuario> resultList = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return resultList.stream().collect(Collectors.toSet());
	}
	
}