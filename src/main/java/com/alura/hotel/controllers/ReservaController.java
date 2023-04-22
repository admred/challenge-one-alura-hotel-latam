package com.alura.hotel.controllers;

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
}
