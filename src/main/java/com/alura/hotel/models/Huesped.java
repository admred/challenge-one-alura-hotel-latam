package com.alura.hotel.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="huespedes")
public class Huesped {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String nacionalidad;
	private String telefono;
	
	@OneToMany(mappedBy="huesped",cascade=CascadeType.ALL)
	private List<Reserva> reservas = new ArrayList<Reserva>();

	public Huesped() {}

	public Huesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public Long getId() {
		return Id;
	}
	
	public void addReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}

	public String getApellido() {
		return apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Object[] toArray() {
		return new Object[] {
				this.Id.toString(),
				this.getNombre(),
				this.getApellido(),
				this.getFechaNacimiento().toString(),
				this.getNacionalidad(),
				this.getTelefono(),
				this.reservas.size()+""
		};
	}
}
