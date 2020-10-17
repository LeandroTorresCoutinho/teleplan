package com.teleplan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.teleplan.model.Plano;
import com.teleplan.model.Tipo;

public interface PlanoRepository extends CrudRepository<Plano, Long>{

	public Optional<Plano> findByCodigoDDD(String ddd);
	public Optional<Plano> findByIdTipo(Tipo tipo);
	public Optional<Plano> findByCodigoDDDAndIdTipoAllIgnoreCase(String ddd, Tipo tipo);
	public Optional<Plano> findByCodigoDDDAndOperadoraAllIgnoreCase(String ddd, String operadora);
	public Optional<Plano> findByCodigoDDDAndId(String ddd, long id);
}
