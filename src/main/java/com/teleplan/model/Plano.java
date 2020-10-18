package com.teleplan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plano")
public class Plano {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String codigoDDD;
	private int minutos;
	private int franquiaDeInternet;
	private double valor;
	private String operadora;	
		
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private Tipo tipo;
	
	public Plano() {
		super();
	}

	public Plano(String codigoDDD, int minutos, int franquiaDeInternet, double valor, Tipo tipo, String operadora) {
		super();
		this.codigoDDD = codigoDDD;
		this.minutos = minutos;
		this.franquiaDeInternet = franquiaDeInternet;
		this.valor = valor;
		this.tipo = tipo;
		this.operadora = operadora;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

}
