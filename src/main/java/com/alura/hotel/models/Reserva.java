package com.alura.hotel.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private BigDecimal valor = new BigDecimal(0);
	private String formaPago;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Huesped huesped;
	
	public Reserva() {}
	
	public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, BigDecimal valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, BigDecimal valor, String formaPago, Huesped huesped) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
		this.huesped = huesped;
	}

	public Huesped getHuesped() {
		return huesped;
	}
}
