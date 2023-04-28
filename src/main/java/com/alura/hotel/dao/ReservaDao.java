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
	
	public Reserva getById(Long id) {
		return em.find(Reserva.class, id);
	}
	
	public List<Reserva> list(){
		final String jqpl="SELECT r FROM Reserva AS r";
		return em.createQuery(jqpl,Reserva.class).getResultList();
	}
	
	public void remove(Reserva reserva) {
		Reserva h=em.merge(reserva);
		em.remove(h);
	}
	
	public void save(Reserva reserva) {
		em.persist(reserva);
	}
	
	public void  update(Reserva reserva) {
		em.merge(reserva);
	}

	public List<Reserva> search(String word) {
		final String jqpl="SELECT r FROM Reserva AS r WHERE r.fechaEntrada=:word OR r.fechaSalida=:word OR r.valor=:word OR r.formaPago=:word";
		return em.createQuery(jqpl,Reserva.class).setParameter("word",word).getResultList();
	}
}
