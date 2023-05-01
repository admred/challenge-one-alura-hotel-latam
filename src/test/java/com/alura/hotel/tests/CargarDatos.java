package com.alura.hotel.tests;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import com.alura.hotel.dao.HuespedDao;
import com.alura.hotel.dao.ReservaDao;
import com.alura.hotel.models.Huesped;
import com.alura.hotel.models.Reserva;
import com.alura.hotel.utils.JPAUtils;

/*
 * Remplazar "update" por "create-drop" en persistence.xml
 *
 */

public class CargarDatos {
	
	public CargarDatos() {
		
		
		Huesped huesped1=new Huesped("Jonatan Brian","Palacios Guemes",Date.valueOf("1980-04-05"),"mexicano-mexicana","010-021-4334732");
		Huesped huesped2=new Huesped("Soledad Romina","Jofre Romero",Date.valueOf("2001-06-23"),"argentino-argentina","872-477421");
		Huesped huesped3=new Huesped("Esteban Joel","Sarmiento",Date.valueOf("1994-12-03"),"chileno-chilena","354-03-757754");
		
		List<Reserva> reservas=Arrays.asList(
				new Reserva(Date.valueOf("2023-06-01"),Date.valueOf("2023-06-10"),new BigDecimal("1330"),"Tarjeta de Débito",huesped1),
				new Reserva(Date.valueOf("2023-07-10"),Date.valueOf("2023-07-12"),new BigDecimal("700"),"Dinero en efectivo",huesped2),
				new Reserva(Date.valueOf("2023-08-20"),Date.valueOf("2023-08-21"),new BigDecimal("300"),"Tarjeta de Crédito",huesped3),
				new Reserva(Date.valueOf("2023-09-13"),Date.valueOf("2023-09-14"),new BigDecimal("300"),"Tarjeta de Crédito",huesped3)
				);
		
		
		
		EntityManager em=JPAUtils.getEntityManager();
		HuespedDao huespedDao=new HuespedDao(em);
		ReservaDao reservaDao=new ReservaDao(em);
		
		em.getTransaction().begin();
		
				
		huespedDao.save(huesped1);
		huespedDao.save(huesped2);
		huespedDao.save(huesped3);
		
		reservas.forEach(res -> reservaDao.save(res));
		
		em.getTransaction().commit();
		
		List<Reserva> list=reservaDao.list();
		list.stream().map(Reserva::getHuesped).map(Huesped::getNombre).forEach(System.out::println);
		
		
		em.close();
	}
	
	public static void main(String[] args) {
		new CargarDatos();
	}
}
