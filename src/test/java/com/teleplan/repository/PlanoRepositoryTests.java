package com.teleplan.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teleplan.model.Plano;
import com.teleplan.model.Tipo;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@DataJpaTest
public class PlanoRepositoryTests {

	@Autowired
	private PlanoRepository repository;

	@DisplayName("deveSalvarUmPlano")
	@Test
	public void deveSalvarUmPlano() {
		Tipo tipo = new Tipo(1, "Pré");
		Plano plano = new Plano("021", 200, 200, 200.00, tipo, "vivo");
		plano = repository.save(plano);
		Optional<Plano> elemento = repository.findById(plano.getId());
		Plano planoAux = new Plano();
		if (elemento.isPresent()) {
			planoAux = elemento.get();
		}
		assertNotNull(plano);
		assertEquals(plano.getId(), planoAux.getId());
	}

	@DisplayName("deveNaoRetornarPlanosSeNaoExistirNenhum")
	@Test
	public void deveNaoRetornarPlanosSeNaoExistirNenhum() {
		Iterable<Plano> planos = repository.findAll();
		assertThat(planos).isEmpty();
	}

	@DisplayName("deveRetornarTodosOsPlanos")
	@Test
	public void deveRetornarTodosOsPlanos() {
		Tipo tipo = new Tipo(1, "Pré");
		Plano plano = new Plano("022", 200, 200, 200.00, tipo, "claro");
		plano = repository.save(plano);
		
		Tipo tipo2 = new Tipo(2, "Pós");
		Plano plano2 = new Plano("021", 200, 200, 200.00, tipo2, "tim");
		plano2 = repository.save(plano2);
		
		Tipo tipo3 = new Tipo(3, "Controle");
		Plano plano3 = new Plano("011", 200, 200, 200.00, tipo3, "vivo");
		plano3 = repository.save(plano3);

	    Iterable<Plano> planos = repository.findAll();

	    assertThat(planos).hasSize(3).contains(plano, plano2, plano3);
	}

	@DisplayName("deveRetornarUmPlanoPeloId")
	@Test
	public void deveRetornarUmPlanoPeloId() {
		Tipo tipo = new Tipo(1, "Pós");
		Plano plano1 = new Plano("022", 100, 100, 100.00, tipo, "claro");
		plano1 = repository.save(plano1);

		Tipo tipo2 = new Tipo(2, "Pré");
	    Plano plano2 = new Plano("021", 200, 200, 200.00, tipo2, "tim");
	    plano2 = repository.save(plano2);

	    Plano planoAux = repository.findById(plano1.getId()).get();

	    assertThat(planoAux).isEqualTo(plano1);
	}

	@DisplayName("deveRetornarOsPlanosDeUmDeterminadoDDD")
	@Test
	public void deveRetornarOsPlanosDeUmDeterminadoDDD() {
		Tipo tipo = new Tipo(1, "Pré");
		Plano plano = new Plano("022", 200, 200, 200.00, tipo, "claro");
		plano = repository.save(plano);
		
		Tipo tipo2 = new Tipo(2, "Pós");
		Plano plano2 = new Plano("022", 200, 200, 200.00, tipo2, "tim");
		plano2 = repository.save(plano2);
		
		Tipo tipo3 = new Tipo(3, "Controle");
		Plano plano3 = new Plano("011", 200, 200, 200.00, tipo3, "vivo");
		plano3 = repository.save(plano3);
		

	    Iterable<Plano> planos = repository.findByCodigoDDD("022");

	    assertThat(planos).hasSize(2).contains(plano, plano2);
	}

	@DisplayName("deveRetornarOsPlanosDeUmDeterminadoTipo")
	@Test
	public void deveRetornarOsPlanosDeUmDeterminadoTipo() {
		Tipo tipo = new Tipo(1, "Pré");
		Plano plano = new Plano("022", 200, 200, 200.00, tipo, "claro");
		plano = repository.save(plano);
		
		Plano plano2 = new Plano("022", 200, 200, 200.00, tipo, "tim");
		plano2 = repository.save(plano2);
		
		Tipo tipo3 = new Tipo(3, "Controle");
		Plano plano3 = new Plano("011", 200, 200, 200.00, tipo3, "vivo");
		plano3 = repository.save(plano3);
		

	    Iterable<Plano> planos = repository.findByTipo(tipo);

	    assertThat(planos).hasSize(2).contains(plano, plano2);
	}

	@DisplayName("deveAtualizarUmPlanoPeloId")
	@Test
	public void deveAtualizarUmPlanoPeloId() {
		Tipo tipo = new Tipo(1, "Pré");
		Plano plano = new Plano("021", 200, 200, 200.00, tipo, "vivo");
		plano = repository.save(plano);
		plano = new Plano("022", 100, 100, 100.00, tipo, "tim");
		plano = repository.save(plano);
		
		Optional<Plano> elemento = repository.findById(plano.getId());
		Plano planoAux = new Plano();
		if (elemento.isPresent()) {
			planoAux = elemento.get();
		}
		assertNotNull(plano);
		assertEquals(plano.getCodigoDDD(), planoAux.getCodigoDDD());
		
	}

	@DisplayName("deveDeletarUmPlanopeloId")
	@Test
	public void deveDeletarUmPlanopeloId() {
		Tipo tipo = new Tipo(1, "Pré");
		Plano plano = new Plano("021", 200, 200, 200.00, tipo, "vivo");
		plano = repository.save(plano);
		repository.delete(plano);
		
		Optional<Plano> elemento = repository.findById(plano.getId());
		assertEquals(elemento, Optional.empty());
	}

	@DisplayName("deveDeletarTodosOsPlanos")
	@Test
	public void deveDeletarTodosOsPlanos() {
		Tipo tipo = new Tipo(1, "Pré");
		Plano plano = new Plano("022", 200, 200, 200.00, tipo, "claro");
		plano = repository.save(plano);
		
		Plano plano2 = new Plano("022", 200, 200, 200.00, tipo, "tim");
		plano2 = repository.save(plano2);
		
		Tipo tipo3 = new Tipo(3, "Controle");
		Plano plano3 = new Plano("011", 200, 200, 200.00, tipo3, "vivo");
		plano3 = repository.save(plano3);
		
		repository.deleteAll();
		

	    Iterable<Plano> planos = repository.findAll();

	    assertThat(planos).hasSize(0);
		
	}
	
	@DisplayName("deveRetornarPlanosPorDDDETipo")
	@Test
	public void deveRetornarPlanosPorDDDETipo() {
		Tipo tipo = new Tipo(2, "Pós");
		Plano plano = new Plano("022", 200, 200, 200.00, tipo, "claro");
		plano = repository.save(plano);
		
		Tipo tipo2 = new Tipo(2, "Pós");
		Plano plano2 = new Plano("022", 200, 200, 200.00, tipo2, "tim");
		plano2 = repository.save(plano2);
		
		Tipo tipo3 = new Tipo(3, "Controle");
		Plano plano3 = new Plano("022", 200, 200, 200.00, tipo3, "vivo");
		plano3 = repository.save(plano3);
		
		List<Plano> list = repository.findByCodigoDDDAndTipoAllIgnoreCase("022", tipo);
		

	    assertThat(list).hasSize(2);
	}
	
	@DisplayName("deveRetornarPlanosPorDDDEOperadora")
	@Test
	public void deveRetornarPlanosPorDDDEOperadora() {
		Tipo tipo = new Tipo(1, "Pré");
		Plano plano = new Plano("022", 100, 100, 100.00, tipo, "claro");
		plano = repository.save(plano);
		
		Tipo tipo2 = new Tipo(2, "Pós");
		Plano plano2 = new Plano("022", 200, 200, 200.00, tipo2, "claro");
		plano2 = repository.save(plano2);
		
		Tipo tipo3 = new Tipo(3, "Controle");
		Plano plano3 = new Plano("022", 200, 200, 200.00, tipo3, "vivo");
		plano3 = repository.save(plano3);
		
		List<Plano> list = repository.findByCodigoDDDAndOperadoraAllIgnoreCase("022", "claro");
		
	    assertThat(list).hasSize(2);
	}
	
	@DisplayName("deveRetornarPlanosPorDDDEId")
	@Test
	public void deveRetornarPlanosPorDDDEId() {
		Tipo tipo = new Tipo(1, "Pré");
		Plano plano = new Plano("022", 100, 100, 100.00, tipo, "claro");
		plano = repository.save(plano);
		
		Tipo tipo2 = new Tipo(2, "Pós");
		Plano plano2 = new Plano("022", 200, 200, 200.00, tipo2, "claro");
		plano2 = repository.save(plano2);
		
		Tipo tipo3 = new Tipo(3, "Controle");
		Plano plano3 = new Plano("022", 200, 200, 200.00, tipo3, "vivo");
		plano3 = repository.save(plano3);
		
		Optional<Plano> elemento = repository.findByCodigoDDDAndId("022", plano.getId());
		
	    assertThat(elemento.get()).isEqualTo(plano);
	}
	

}
