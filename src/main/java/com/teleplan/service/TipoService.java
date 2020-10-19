package com.teleplan.service;

import java.util.Optional;

import com.teleplan.model.Tipo;

public interface TipoService {

	public Optional<Tipo> findByDescricaoAllIgnoreCase(String descricao);
}
