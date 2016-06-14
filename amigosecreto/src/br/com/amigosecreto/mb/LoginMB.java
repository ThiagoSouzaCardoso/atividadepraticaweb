package br.com.amigosecreto.mb;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.amigosecreto.dao.UsuarioDao;
import br.com.amigosecreto.entity.Usuario;

@SessionScoped
@ManagedBean
public class LoginMB {
	
		private String login;
		private String senha;
		private Map<String, Object> sessionMap;
		
		public LoginMB() {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			sessionMap = externalContext.getSessionMap();
		}
		
		public String autenticar(){
			UsuarioDao dao = new UsuarioDao();
			Usuario usr = dao.autenticacao(login, senha);
			
			if (usr != null) {
				sessionMap.put("usuario_logado", usr);
				return "admin/sorteio?faces-redirect=true";
			} else {
				return "acesso?faces-redirect=true";
			}
		}

		
		public String cadastrar() {
			return "cadastro";
		}
		

		
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
	
	

}
