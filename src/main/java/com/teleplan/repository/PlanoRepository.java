package com.teleplan.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.teleplan.model.Plano;
import com.teleplan.model.Tipo;

public interface PlanoRepository extends CrudRepository<Plano, Long>{

	public List<Plano> findByCodigoDDD(String ddd);
	public List<Plano> findByIdTipo(Tipo tipo);
	public List<Plano> findByCodigoDDDAndIdTipoAllIgnoreCase(String ddd, Tipo tipo);
	public List<Plano> findByCodigoDDDAndOperadoraAllIgnoreCase(String ddd, String operadora);
	public List<Plano> findByCodigoDDDAndId(String ddd, long id);
}
