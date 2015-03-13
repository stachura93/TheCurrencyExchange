package org.stachura.TheCurrencyExchange.user.service;

import java.util.List;

import org.stachura.TheCurrencyExchange.model.User;

/**
 *
 * User Service Interface
 *
 * @author Stachura Bartłomiej
 * @since 5 Mar 2015
 * @version 1.0.0
 *
 */
public interface IUserService {

	/**
	 * Add User
	 *
	 * @param User
	 *            user
	 */
	public void addUser(User user);

	/**
	 * Update User
	 *
	 * @param User
	 *            user
	 */
	public void updateUser(User user);

	/**
	 * Delete User
	 *
	 * @param User
	 *            user
	 */
	public void deleteUser(User user);

	/**
	 * Get User
	 *
	 * @param int User Id
	 */
	public User getUserById(int id);
	
	/**
	 * Get User
	 *
	 * @param String User name
	 */
	public User getUserByName(String name);

	/**
	 * Get User List
	 *
	 * @return List - User list
	 */
	public List<User> getUsers();
}