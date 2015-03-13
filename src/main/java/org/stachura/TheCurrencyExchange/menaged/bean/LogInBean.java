package org.stachura.TheCurrencyExchange.menaged.bean;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.stachura.TheCurrencyExchange.model.User;
import org.stachura.TheCurrencyExchange.user.service.IUserService;

@Named("logInMB")
@Scope("session")
public class LogInBean implements Serializable {

	static Logger log = Logger.getLogger(UserManagedBean.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	private User user;
	private String login;
	private String password;

	@Inject
	IUserService userService;

	public String checkPerson() {
		try {
			this.setUser(getUserService().getUserByName(getLogin()));
		} catch (IndexOutOfBoundsException e) {
			return ERROR;
		}
		if (passwordThatSame(getUser()) == true)
			return SUCCESS;
		return ERROR;
	}

	private boolean passwordThatSame(User user) {
		if (getUser().getSurname().equals(getPassword()))
			return true;
		return false;
	}

	public String getPassword() {
		return password;
	}

	public String getLogin() {
		return login;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
