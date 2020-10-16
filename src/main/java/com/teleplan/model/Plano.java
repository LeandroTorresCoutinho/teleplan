package com.teleplan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Plano {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String codigoDDD;
	private int minutos;
	private int franquiaDeInternet;
	private double valor;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Tipo idTipo;
	private String operadora;	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoDDD() {
		return codigoDDD;
	}
	public void setCodigoDDD(String codigo) {
		this.codigoDDD = codigo;
	}
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	public int getFranquiaDeInternet() {
		return franquiaDeInternet;
	}
	public void setFranquiaDeInternet(int franquiaDeInternet) {
		this.franquiaDeInternet = franquiaDeInternet;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Tipo getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Tipo idTipo) {
		this.idTipo = idTipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

}
