package br.com.amigosecreto.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.amigosecreto.entity.Usuario;

@WebFilter("/admin/*")
public class FiltroAcesso implements Filter{
	

	    public FiltroAcesso() {
	        // TODO Auto-generated constructor stub
	    }

		public void destroy() {
			// TODO Auto-generated method stub
		}

		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
			if (usuario == null) {
				request.getRequestDispatcher("../acesso.jsf").forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		}

		/**
		 * @see Filter#init(FilterConfig)
		 */
		public void init(FilterConfig fConfig) throws ServletException {
			// TODO Auto-generated method stub
		}

	}

	
