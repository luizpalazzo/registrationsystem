package br.com.luizpalazzo.filter;

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

/**
 * Servlet Filter implementation class FiltroAutenticacao
 */

@WebFilter(urlPatterns = { "/restricted/dashboard.jsp","/restricted/change_password.jsp"})
public class FilterSessionRestricted implements Filter {

    /**
     * Default constructor. 
     */
    public FilterSessionRestricted() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request = (HttpServletRequest)request;
		response = (HttpServletResponse)response;
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if((session != null) && (session.getAttribute("usuario")!=null)){
			System.out.println("usuario logado");
			chain.doFilter(request, response);
		}else{			
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath()+"/index.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
