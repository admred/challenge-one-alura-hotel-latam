package com.alura.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.alura.hotel.models.User;

public class UserDao {
	private EntityManager em;

	public UserDao() {}

	public UserDao(EntityManager em) {
		this.em = em;
	}
	
	public void save(User user) {
		em.persist(user);
	}
	
	public void remove(User user) {
		User u=em.merge(user);
		em.remove(u);
	}
	
	public void  update(User user) {
		em.merge(user);
	}
	
	public User getById(Long id) {
		return em.find(User.class, id);
	}
	
	public User getByName(String username) {
		final String jqpl="SELECT u FROM User AS u WHERE u.username=:username";
		return em.createQuery(jqpl,User.class).setParameter("username", username).getSingleResult();
	}
	
	public List<User> list(){
		final String jqpl="SELECT u FROM User AS u";
		return em.createQuery(jqpl,User.class).getResultList();
	}
}
