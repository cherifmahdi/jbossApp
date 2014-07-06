package ctr.filter;

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

import ctr.SessionCtr;

//@WebFilter(urlPatterns="/filterPage/*")
@WebFilter("/faces/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		//System.out.println(" url = "
		//		+ ((HttpServletRequest) servletRequest).getRequestURL());
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		SessionCtr loginBean = (SessionCtr) request.getSession().getAttribute(
				"sessionCtr");
		
		String red =  ((HttpServletRequest) servletRequest).getRequestURL().toString();
		//System.out.println(red);
		//loginBean.setRedirection(red);
		

		if (loginBean != null && loginBean.isLogged()) {
			filterChain.doFilter(request, response);
		} else if (request.getRequestURL().toString().contains("login.xhtml")) {
			filterChain.doFilter(request, response);

		} else {
			response.sendRedirect(request.getContextPath()
					+ "/faces/login/login.xhtml");
		}



	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}