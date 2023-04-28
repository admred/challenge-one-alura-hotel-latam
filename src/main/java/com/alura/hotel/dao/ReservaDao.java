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
		final String jpql="SELECT r FROM Reserva AS r";
		return em.createQuery(jpql,Reserva.class).getResultList();
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

	public List<Reserva> search(String busqueda) {
		//final String jqpl="SELECT r FROM Reserva AS r WHERE r.fechaEntrada=:word OR r.fechaSalida=:word OR r.valor=:word OR r.formaPago=:word";
		final String jpql="SELECT r FROM Reserva r WHERE"
				+" r.fechaEntrada LIKE '%'||:busqueda||'%' OR"
				+" r.fechaSalida LIKE '%'||:busqueda||'%' OR"
				+" CAST(r.valor AS java.lang.String)=:busqueda OR"
				+" r.formaPago LIKE '%'||:busqueda||'%'";
		
		return em.createQuery(jpql,Reserva.class).setParameter("busqueda",busqueda).getResultList();
	}
}
