package org.stachura.TheCurrencyExchange.user.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.SessionFactory;
import org.stachura.TheCurrencyExchange.model.User;

/**
 *
 * User DAO
 *
 * @author Stachura Bartłomiej
 * @since 5 Mar 2015
 * @version 1.0.0
 *
 */
@Named
public class UserDAO implements IUserDAO {
	/**
	 * 
	 */
	@Inject
	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 *
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 *
	 * @param SessionFactory
	 *            - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Add User
	 *
	 * @param User
	 *            user
	 */
	public void addUser(User user) {
		getSessionFactory().getCurrentSession().save(user);
	}

	/**
	 * Delete User
	 *
	 * @param User
	 *            user
	 */
	public void deleteUser(User user) {
		getSessionFactory().getCurrentSession().delete(user);
	}

	/**
	 * Update User
	 *
	 * @param User
	 *            user
	 */
	public void updateUser(User user) {
		getSessionFactory().getCurrentSession().update(user);
	}

	/**
	 * Get User
	 *
	 * @param int User Id
	 * @return User
	 */
	public User getUserById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from User where id=?").setParameter(0, id).list();
		return (User) list.get(0);
	}

	/**
	 * Get User List
	 *
	 * @return List - User list
	 */
	public List<User> getUsers() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from User").list();
		return list;
	}
	/**
	 * Get User
	 * @param String User name
	 * @return User
	 */
	@Override
	public User getUserByName(String name) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from User where name=?").setParameter(0, name).list();
		return (User) list.get(0);
	}

}