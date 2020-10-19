package com.teleplan.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.teleplan.model.Tipo;

public interface TipoRepository extends CrudRepository<Tipo, Long>{
	
	public Optional<Tipo> findByDescricaoAllIgnoreCase(String descricao);
}
