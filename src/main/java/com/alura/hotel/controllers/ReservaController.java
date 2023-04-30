package com.alura.hotel.controllers;



import java.util.List;

import javax.persistence.EntityManager;

import com.alura.hotel.dao.ReservaDao;
import com.alura.hotel.models.Reserva;
import com.alura.hotel.utils.JPAUtils;

public class ReservaController {
	
	private ReservaDao reservaDao;
	
	private EntityManager em;
	
	public ReservaController() {
		em=JPAUtils.getEntityManager();
		reservaDao=new ReservaDao(em);
	}
	
	public void save(Reserva reserva) { 
		em.getTransaction().begin();
		reservaDao.save(reserva);
		em.getTransaction().commit();
	}
		
	public void update(Reserva reserva) {
		em.getTransaction().begin();
		reservaDao.update(reserva);
		em.getTransaction().commit();
	}
	
	public Reserva getById(Long id) {
		return reservaDao.getById(id);
	}
	
	public List<Reserva> list(){
		return reservaDao.list();
	}
	
	public List<Reserva> search(String busqueda) {
		return reservaDao.search(busqueda);
	}

	
	public void removeById(Long id) {
		em.getTransaction().begin();
		reservaDao.removeById(id);
		em.getTransaction().commit();
	}

	public void removeReservasWithHuespedId(Long id) {
		em.getTransaction().begin();
		reservaDao.removeReservasWithHuespedId(id);
		em.getTransaction().commit();
	}
}
