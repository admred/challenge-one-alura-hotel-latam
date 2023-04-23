package com.alura.hotel.controllers;

import javax.persistence.EntityManager;

import com.alura.hotel.dao.HuespedDao;
import com.alura.hotel.models.Huesped;
import com.alura.hotel.utils.JPAUtils;

public class HuespedController {
	
	private HuespedDao huespedDao;
	
	private EntityManager em;
	
	public HuespedController() {
		em=JPAUtils.getEntityManager();
		huespedDao=new HuespedDao(em);
	}
	
	public void save(Huesped huesped) {
		em.getTransaction().begin();
		huespedDao.save(huesped);
		em.getTransaction().commit();
	}
}
