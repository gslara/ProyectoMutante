package com.example.main.dtos;

public class StatsDTO {

	private long contadorMutante;
	private long contadorHumano;
	private float ratio;
	
	
	//CONSTRUCTORES
	public StatsDTO() {
	}


	public StatsDTO(long contadorMutante, long contadorHumano, float ratio) {
		this.contadorMutante = contadorMutante;
		this.contadorHumano = contadorHumano;
		this.ratio = ratio;
	}


	//GETTERS Y SETTERS
	public long getContadorMutante() {
		return contadorMutante;
	}


	public void setContadorMutante(long contadorMutante) {
		this.contadorMutante = contadorMutante;
	}


	public long getContadorHumano() {
		return contadorHumano;
	}


	public void setContadorHumano(long contadorHumano) {
		this.contadorHumano = contadorHumano;
	}


	public float getRatio() {
		return ratio;
	}


	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
	
	
	
}
