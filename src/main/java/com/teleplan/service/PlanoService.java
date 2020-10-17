package com.teleplan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teleplan.model.Plano;
import com.teleplan.model.Tipo;

public interface PlanoService {
	
	public List<Plano> findByCodigoDDD(String ddd);
	
	public List<Plano> findByIdTipo(Tipo tipo);
}
