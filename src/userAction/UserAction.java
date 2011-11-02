package userAction;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import lib.ServiceFinder;
import bol.*;
import domain.*;

public class UserAction extends ActionSupport{

	private static final long serialVersionUID = 1L; 
	private String username;
	private String password;
	public String showLogin() {
		return SUCCESS;
	}

	public String doLogin() {
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			
			Users entity = new Users();
			entity.setUsername(username);
			entity.setPassword(password);
			IUserBO IUserBO = (IUserBO) ServiceFinder.getContext(request).getBean("userAOP");
			boolean result = IUserBO.checkLogin(entity);
			if (result == true) {
				session.setAttribute("adminLogin", entity.getUsername());
				return SUCCESS;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		addActionError("Wrong username or password");
		return INPUT;
	}

	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("adminLogin");
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
