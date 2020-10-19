package com.teleplan.service;

import java.util.List;
import java.util.Optional;

import com.teleplan.model.Plano;
import com.teleplan.model.Tipo;

public interface PlanoService {
	
	public Plano save(String codigoDDD, int minutos, int franquiaDeInternet, double valor, String tipo, String operadora);
	public Plano update(long id, String codigoDDD, int minutos, int franquiaDeInternet, double valor, String tipo, String operadora);
	public void deleteById(long id);
	public List<Plano> findByCodigoDDD(String ddd);
	public List<Plano> findByTipo(Tipo tipo);
	public List<Plano> findByCodigoDDDAndTipoAllIgnoreCase(String ddd, String tipo);
	public List<Plano> findByCodigoDDDAndOperadoraAllIgnoreCase(String ddd, String operadora);
	public Optional<Plano> findByCodigoDDDAndId(String ddd, long id);
}
