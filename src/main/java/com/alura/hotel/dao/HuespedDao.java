package com.alura.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.alura.hotel.models.Huesped;

public class HuespedDao {
	private EntityManager em;

	public HuespedDao() {}

	public HuespedDao(EntityManager em) {
		this.em = em;
	}
	
	public Huesped getById(Long id) {
		return em.find(Huesped.class, id);
	}
	
	public List<Huesped> list(){
		final String jqpl="SELECT h FROM Huesped AS h";
		return em.createQuery(jqpl,Huesped.class).getResultList();
	}
	
	public void remove(Huesped huesped) {
		Huesped h=em.merge(huesped);
		em.remove(h);
	}
	
	public void save(Huesped huesped) {
		em.persist(huesped);
	}
	
	public void  update(Huesped huesped) {
		em.merge(huesped);
	}
}
