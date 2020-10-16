package com.teleplan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Tipo {

	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String descricao;
	
	public int getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
}
