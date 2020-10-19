package com.teleplan.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.teleplan.model.Tipo;
import com.teleplan.repository.TipoRepository;
import com.teleplan.service.TipoService;

@Service
public class TipoServiceImpl implements TipoService{

	private TipoRepository tipoRepository;
	
	@Override
	public Optional<Tipo> findByDescricaoAllIgnoreCase(String descricao) {
		return tipoRepository.findByDescricaoAllIgnoreCase(descricao);
	}

	
}
