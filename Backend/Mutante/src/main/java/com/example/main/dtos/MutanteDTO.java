package com.example.main.dtos;

public class MutanteDTO {

	private int id;
	private String nombre;
	private String apellido;
	private String [] dna = new String [6];
	private String mutacion;
	
	
	//CONSTRUCTORES
	public MutanteDTO() {
	}

	public MutanteDTO(String nombre, String apellido, String[] dna, String mutacion) {
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
