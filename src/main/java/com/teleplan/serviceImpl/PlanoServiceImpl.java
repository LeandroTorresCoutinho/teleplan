package com.teleplan.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleplan.model.Plano;
import com.teleplan.model.Tipo;
import com.teleplan.repository.PlanoRepository;
import com.teleplan.repository.TipoRepository;
import com.teleplan.service.PlanoService;

@Service
public class PlanoServiceImpl implements PlanoService{

	@Autowired
	private PlanoRepository planoRepository;

	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	public List<Plano> findByCodigoDDD(String ddd) {
		return planoRepository.findByCodigoDDD(ddd);
	}

	@Override
	public List<Plano> findByTipo(Tipo tipo) {
		return planoRepository.findByTipo(tipo);
	}

	@Override
	public List<Plano> findByCodigoDDDAndTipoAllIgnoreCase(String ddd, String tipo) {
		Optional<Tipo> tipoAux = tipoRepository.findByDescricaoAllIgnoreCase(tipo);
		if(tipoAux.isPresent())
			return planoRepository.findByCodigoDDDAndTipoAllIgnoreCase(ddd, tipoAux.get());
		return null;
	}

	@Override
	public List<Plano> findByCodigoDDDAndOperadoraAllIgnoreCase(String ddd, String operadora) {
		return planoRepository.findByCodigoDDDAndOperadoraAllIgnoreCase(ddd, operadora);
	}

	@Override
	public Optional<Plano> findByCodigoDDDAndId(String ddd, long id) {
		return planoRepository.findByCodigoDDDAndId(ddd, id);
	}

}
