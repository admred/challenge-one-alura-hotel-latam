package com.alura.hotel.tests;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import com.alura.hotel.models.*;
import com.alura.hotel.dao.*;
import com.alura.hotel.utils.JPAUtils;

public class CargarDatos {
	public CargarDatos() {
		Huesped huesped1=new Huesped("Jonatan Brian","Palacios Guemes",LocalDate.parse("1980-04-05"),"Chile","010-021-4334732");
		Huesped huesped2=new Huesped("Soledad Romina","Jofre Romero",LocalDate.parse("2001-06-23"),"Uruguay","872-477421");
		Huesped huesped3=new Huesped("Esteban Joel","Sarmiento",LocalDate.parse("1994-12-03"),"Argentina","354-03-757754");
		
		List<Reserva> reserva1=Arrays.asList(
				new Reserva(LocalDate.parse("2023-06-01"),LocalDate.parse("2023-06-10"),new BigDecimal("1330"),"efectivo",huesped1)
				);
		
		List<Reserva> reserva2=Arrays.asList(
				new Reserva(LocalDate.parse("2023-07-10"),LocalDate.parse("2023-07-12"),new BigDecimal("700"),"tarjeta",huesped2)
				);
		
		List<Reserva> reserva3=Arrays.asList(
				new Reserva(LocalDate.parse("2023-08-20"),LocalDate.parse("2023-08-21"),new BigDecimal("300"),"tarjeta",huesped3),
				new Reserva(LocalDate.parse("2023-09-13"),LocalDate.parse("2023-09-14"),new BigDecimal("300"),"tarjeta",huesped3)
				);
		
		
		
		EntityManager em=JPAUtils.getEntityManager();
		HuespedDao huespedDao=new HuespedDao(em);
		ReservaDao reservaDao=new ReservaDao(em);
		
		em.getTransaction().begin();
		
		
		huespedDao.save(huesped1);
		huespedDao.save(huesped2);
		huespedDao.save(huesped3);
		
		reserva1.forEach(res -> reservaDao.save(res));
		reserva2.forEach(res -> reservaDao.save(res));
		reserva3.forEach(res -> reservaDao.save(res));
		
		em.getTransaction().commit();
		
		Reserva reserva=em.find(Reserva.class, 4l);
		System.out.println(reserva.getHuesped().getNombre());
		
		
		em.close();
	}
	
	public static void main(String[] args) {
		new CargarDatos();
	}
}
