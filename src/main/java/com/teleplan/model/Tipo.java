package com.teleplan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String descricao;
	
	public Tipo() {
		super();
	}

	public Tipo(long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public long getId() {
		return id;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
}
