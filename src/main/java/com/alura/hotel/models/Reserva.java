package com.alura.hotel.models;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private BigDecimal valor = new BigDecimal(0);
	private String formaPago;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Huesped huesped;
	
	public Reserva() {}
	
	public Reserva(Date fechaEntrada, Date fechaSalida, BigDecimal valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reserva(Date fechaEntrada, Date fechaSalida, BigDecimal valor, String formaPago, Huesped huesped) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
		this.huesped = huesped;
	}
	
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public Long getId() {
		return Id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Object[] toArray() {
		return new Object[] {
			this.Id.toString(),
			this.fechaEntrada.toString(),
			this.fechaSalida.toString(),
			this.valor.toString(),
			this.getFormaPago()
		};
	}
}
