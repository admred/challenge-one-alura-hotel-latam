package com.alura.hotel.tests;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import com.alura.hotel.models.*;
import com.alura.hotel.dao.*;
import com.alura.hotel.utils.JPAUtils;

public class CargarDatos {
	public CargarDatos() {
		User admin=new User("admin","1234");
		
		Huesped huesped1=new Huesped("Jonatan Brian","Palacios Guemes",Date.valueOf("1980-04-05"),"Chile","010-021-4334732");
		Huesped huesped2=new Huesped("Soledad Romina","Jofre Romero",Date.valueOf("2001-06-23"),"Uruguay","872-477421");
		Huesped huesped3=new Huesped("Esteban Joel","Sarmiento",Date.valueOf("1994-12-03"),"Argentina","354-03-757754");
		
		List<Reserva> reservas=Arrays.asList(
				new Reserva(Date.valueOf("2023-06-01"),Date.valueOf("2023-06-10"),new BigDecimal("1330"),"efectivo",huesped1),
				new Reserva(Date.valueOf("2023-07-10"),Date.valueOf("2023-07-12"),new BigDecimal("700"),"tarjeta",huesped2),
				new Reserva(Date.valueOf("2023-08-20"),Date.valueOf("2023-08-21"),new BigDecimal("300"),"debito",huesped3),
				new Reserva(Date.valueOf("2023-09-13"),Date.valueOf("2023-09-14"),new BigDecimal("300"),"debito",huesped3)
				);
		
		
		
		EntityManager em=JPAUtils.getEntityManager();
		HuespedDao huespedDao=new HuespedDao(em);
		ReservaDao reservaDao=new ReservaDao(em);
		UserDao userDao=new UserDao(em);
		
		em.getTransaction().begin();
		
		userDao.save(admin);
				
		huespedDao.save(huesped1);
		huespedDao.save(huesped2);
		huespedDao.save(huesped3);
		
		reservas.forEach(res -> reservaDao.save(res));
		
		em.getTransaction().commit();
		
		Reserva reserva=em.find(Reserva.class, 4l);
		System.out.println(reserva.getHuesped().getNombre());
		
		
		em.close();
	}
	
	public static void main(String[] args) {
		new CargarDatos();
	}
}
