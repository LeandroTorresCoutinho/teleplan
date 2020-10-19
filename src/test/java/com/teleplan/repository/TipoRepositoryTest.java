package com.teleplan.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teleplan.model.Tipo;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
public class TipoRepositoryTest {

	@Autowired
	private TipoRepository repository;

	@DisplayName("deveBuscarUmPlanoPeloId")
	@Test
	public void deveBuscarUmPlano() {
		Tipo tipo = new Tipo(1, "Controle");
		tipo = repository.save(tipo);
		Optional<Tipo> elemento = repository.findById(tipo.getId());
		Tipo tipoAux = new Tipo();
		if (elemento.isPresent()) {
			tipoAux = elemento.get();
		}
		assertNotNull(tipo);
		assertEquals(tipo.getId(), tipoAux.getId());
	}
	
	@DisplayName("deveBuscarUmPlanoPelaDescricao")
	@Test
	public void deveBuscarUmPlanoPelaDescricao() {
		Tipo tipo = new Tipo(1, "Controle");
		tipo = repository.save(tipo);
		Optional<Tipo> elemento = repository.findByDescricaoAllIgnoreCase("controle");
		Tipo tipoAux = new Tipo();
		if (elemento.isPresent()) {
			tipoAux = elemento.get();
		}
		assertNotNull(tipo);
		assertEquals(tipo.getId(), tipoAux.getId());
	}

}
