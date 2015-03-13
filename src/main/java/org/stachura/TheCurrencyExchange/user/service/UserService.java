package org.stachura.TheCurrencyExchange.user.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;
import org.stachura.TheCurrencyExchange.model.User;
import org.stachura.TheCurrencyExchange.user.dao.IUserDAO;

/**
 *
 * User Service
 *
 * @author Stachura Bartłomiej
 * @since 5 Mar 2015
 * @version 1.0.0
 *
 */

@Named
@Transactional(readOnly = true)
public class UserService implements IUserService {

	
	// UserDAO is injected...
	@Inject
	IUserDAO userDAO;

	/**
	 * Add User
	 *
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	public void addUser(User user) {
		getUserDAO().addUser(user);
	}

	/**
	 * Delete User
	 *
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	public void deleteUser(User user) {
		getUserDAO().deleteUser(user);
	}

	/**
	 * Update User
	 *
	 * @param User
	 *            user
	 */
	@Transactional(readOnly = false)
	public void updateUser(User user) {
		getUserDAO().updateUser(user);
	}

	/**
	 * Get User
	 *
	 * @param int User Id
	 */
	public User getUserById(int id) {
		return getUserDAO().getUserById(id);
	}

	/**
	 * Get User List
	 *
	 */
	public List<User> getUsers() {
		return getUserDAO().getUsers();
	}

	/**
	 * Get User DAO
	 *
	 * @return IUserDAO - User DAO
	 */
	public IUserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * Set User DAO
	 *
	 * @param IUserDAO
	 *            - User DAO
	 */
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User getUserByName(String name) {
		return getUserDAO().getUserByName(name);
	}

}