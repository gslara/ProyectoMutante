package com.example.main.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mutante implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "dna")
	private String [] dna = new String [6];
	
	@Column(name = "mutacion")
	private String mutacion;
	
	
	//CONSTRUCTORES
	public Mutante() {
	}

	public Mutante(String nombre, String apellido, String[] dna, String mutacion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dna = dna;
		this.mutacion = mutacion;
	}

	
	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}

	public String getMutacion() {
		return mutacion;
	}

	public void setMutacion(String mutacion) {
		this.mutacion = mutacion;
	}
	
	
}
