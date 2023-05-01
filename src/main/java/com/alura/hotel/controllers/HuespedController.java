package com.alura.hotel.controllers;

import java.util.List;

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

	public List<Huesped> list() {
		return huespedDao.list();
	}

	public List<Huesped> search(String busqueda) {
		return huespedDao.search(busqueda);
	}

	public void removeById(Long id) {
		em.getTransaction().begin();
		huespedDao.removeById(id);
		em.getTransaction().commit();
	}

	public Huesped getById(Long id) {
		return huespedDao.getById(id);
	}

	public void remove(Huesped huesped) {
		em.getTransaction().begin();
		huespedDao.remove(huesped);
		em.getTransaction().commit();
	}
	
	public void update(Huesped huesped) {
		em.getTransaction().begin();
		huespedDao.update(huesped);
		em.getTransaction().commit();
		
	}
}
