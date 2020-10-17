package com.teleplan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleplan.model.Plano;
import com.teleplan.model.Tipo;
import com.teleplan.repository.PlanoRepository;
import com.teleplan.service.PlanoService;

@Service
public class PlanoServiceImpl implements PlanoService{

	@Autowired
	private PlanoRepository planoRepository;
	
	@Override
	public List<Plano> findByCodigoDDD(String ddd) {
		return planoRepository.findByCodigoDDD(ddd);
	}

	@Override
	public List<Plano> findByIdTipo(Tipo tipo) {
		return planoRepository.findByIdTipo(tipo);
	}

}
