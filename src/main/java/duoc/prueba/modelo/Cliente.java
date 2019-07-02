package duoc.prueba.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	@Id
	private String rut;
	
	@Column
	private String nombres;
	
	@Column
	private String apellidos;
	
	@Column
	private String email;
	
	@Column
	private String celular;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String rut, String nombres, String apellidos, String email, String celular) {
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.celular = celular;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Cliente [rut=" + rut + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email=" + email
				+ ", celular=" + celular + "]";
	}
	
	public boolean equals(Cliente cliente) {
		boolean estado = false;
		if (this.rut.equalsIgnoreCase(cliente.getRut()) 
			&& this.nombres.equalsIgnoreCase(cliente.getNombres()) 
			&& this.apellidos.equalsIgnoreCase(cliente.getApellidos())
			&& this.email.equalsIgnoreCase(cliente.getEmail())
			&& this.celular.equalsIgnoreCase(cliente.getCelular())) {
			estado = true;
		}
		return estado;
	}
}
