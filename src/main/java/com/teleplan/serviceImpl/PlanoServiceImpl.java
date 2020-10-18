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

	@Override
	public Plano save(String codigoDDD, int minutos, int franquiaDeInternet, double valor, String tipo,
			String operadora) {
		Optional<Tipo> tipoAux = tipoRepository.findByDescricaoAllIgnoreCase(tipo);
		if(tipoAux.isPresent()) {
			Plano plano = new Plano(codigoDDD, minutos, franquiaDeInternet,valor,tipoAux.get(),operadora);
			return planoRepository.save(plano);
		}else {
			throw new IllegalArgumentException("Tipo de plano inexistente, favor escolher entre(Controle, Pré, Pós)");
		}
			
	}
	
	@Override
	public Plano update(long id, String codigoDDD, int minutos, int franquiaDeInternet, double valor, String tipo,
			String operadora) {
		Optional<Plano> plano = planoRepository.findById(id);
		Plano planoAux = new Plano();
		if(plano.isPresent()) {
			planoAux = plano.get();
		}else {
			throw new IllegalArgumentException("Plano não encontrado");
		}
		Optional<Tipo> tipoAux = tipoRepository.findByDescricaoAllIgnoreCase(tipo);
		if(tipoAux.isPresent()) {
			planoAux.setTipo(tipoAux.get());
		}else {
			throw new IllegalArgumentException("Tipo de plano inexistente, favor escolher entre(Controle, Pré, Pós)");
		}
		planoAux.setCodigoDDD(codigoDDD);
		planoAux.setFranquiaDeInternet(franquiaDeInternet);
		planoAux.setMinutos(minutos);
		planoAux.setOperadora(operadora);
		planoAux.setValor(valor);
		return planoRepository.save(planoAux);
	}

	@Override
	public void deleteById(long id) {
		planoRepository.deleteById(id);
	}
}
