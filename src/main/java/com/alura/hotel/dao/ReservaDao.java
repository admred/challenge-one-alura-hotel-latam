package com.alura.hotel.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.alura.hotel.models.Reserva;

public class ReservaDao {
	private EntityManager em;

	public ReservaDao() {}

	public ReservaDao(EntityManager em) {
		this.em = em;
	}
	
	public void save(Reserva reserva) {
		em.persist(reserva);
	}
	
	public void remove(Reserva reserva) {
		Reserva h=em.merge(reserva);
		em.remove(h);
	}
	
	public void  update(Reserva reserva) {
		em.merge(reserva);
	}
	
	public Reserva getById(Long id) {
		return em.find(Reserva.class, id);
	}
	
	public List<Reserva> list(){
		final String jqpl="SELECT r FROM Reserva AS r";
		return em.createQuery(jqpl,Reserva.class).getResultList();
	}
}
