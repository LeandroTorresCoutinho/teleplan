package com.teleplan.service;

import java.util.List;
import java.util.Optional;

import com.teleplan.model.Plano;
import com.teleplan.model.Tipo;

public interface PlanoService {
	
	public List<Plano> findByCodigoDDD(String ddd);
	public List<Plano> findByIdTipo(Tipo tipo);
	public List<Plano> findByCodigoDDDAndIdTipoAllIgnoreCase(String ddd, Tipo tipo);
	public List<Plano> findByCodigoDDDAndOperadoraAllIgnoreCase(String ddd, String operadora);
	public Optional<Plano> findByCodigoDDDAndId(String ddd, long id);
}
