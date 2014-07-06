package ctr;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ManagedBean
@SessionScoped
public class SessionCtr {

	private boolean isLogged;
	private String sessionOpenn = "hello session";
	HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	String redirection = req.getRequestURL().toString();
	
	
	
	@PostConstruct
	public void init() {
		// System.out.println("hhhhhelooooooooooo");
	}

	public void testConn() {

		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		
		
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		
		String login = request.getParameter("myForm:email");
		String password = request.getParameter("myForm:password");

		//System.out.println("redi="+redirection);
		if (login.equals("cherif.mahdi@live.fr") && password.equals("123456")) {
			isLogged = true;
			
			//
			try {
				//FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/index.xhtml");
				response.sendRedirect(request.getContextPath()+ "/faces/index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			FacesMessage msg = new FacesMessage("Failed to login!!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void verifConn() {

		if (isLogged) {
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/cherifmahdi/faces/addemployee.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {

			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("/cherifmahdi/faces/login/index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public String getSessionOpenn() {
		return sessionOpenn;
	}

	public void setSessionOpenn(String sessionOpenn) {
		this.sessionOpenn = sessionOpenn;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public String getRedirection() {
		return redirection;
	}

	public void setRedirection(String redirection) {
		this.redirection = redirection;
	}

}
