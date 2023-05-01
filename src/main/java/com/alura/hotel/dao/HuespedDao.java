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
		final String jpql="SELECT h FROM Huesped h";
		return em.createQuery(jpql,Huesped.class).getResultList();
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
	
	public List<Huesped> search(String busqueda) {
		final String jqpl="SELECT h FROM Huesped AS h WHERE"
					+" h.nombre   LIKE '%'||:busqueda||'%' OR"
					+" h.apellido LIKE '%'||:busqueda||'%' OR"
					+" h.fechaNacimiento LIKE '%'||:busqueda||'%' OR"
					+" h.nacionalidad LIKE '%'||:busqueda||'%' OR"
					+" h.telefono LIKE '%'||:busqueda||'%'";
					
		return em.createQuery(jqpl,Huesped.class).setParameter("busqueda",busqueda).getResultList();
	}

	public void removeById(Long id) {
		final String jpql="DELETE FROM Huesped h WHERE h.Id=:id";
		em.createQuery(jpql).setParameter("id",id).executeUpdate();
	}
}
