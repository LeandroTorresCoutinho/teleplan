package com.teleplan.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.teleplan.model.Plano;
import com.teleplan.model.Tipo;

public class PlanoControllerTest extends AbstractTest {
	public long planoId;
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void deveBuscarPlanosPeloDDD() throws Exception {
		String uri = "/plano/buscaPeloDDD";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)
				.param("codigoDDD", "022"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Plano[] planolist = super.mapFromJson(content, Plano[].class);
		assertTrue(planolist.length > 0);
	}
	
	@Test
	public void deveBuscarPlanosPeloDDDEOperadora() throws Exception {
		String uri = "/plano/buscaPeloDDDEOperadora";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)
				.param("codigoDDD", "022")
				.param("operadora", "vivo"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Plano[] planolist = super.mapFromJson(content, Plano[].class);
		assertTrue(planolist.length > 0);
	}
	
	@Test
	public void deveBuscarPlanoPeloDDDeId() throws Exception {
		String uri = "/plano/buscaPeloDDDEId";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)
				.param("codigoDDD", "021")
				.param("id", "479"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Plano plano = super.mapFromJson(content, Plano.class);
		assertTrue(plano != null);
	}
	
	@Test
	public void deveBuscarPlanosPeloDDDETipo() throws Exception {
		String uri = "/plano/buscaPeloDDDETipo";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)
				.param("codigoDDD", "011")
				.param("tipo", "Pós"))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Plano[] planolist = super.mapFromJson(content, Plano[].class);
		assertTrue(planolist.length > 0);
	}
	

	@Test
	public void deveSalvarUmPlano() throws Exception {
		String uri = "/plano";
		Tipo tipo = new Tipo(1,"Controle");
		Plano plano = new Plano(99999l,"021",100,200,200,tipo,"vivo");
		String inputJson = super.mapToJson(plano);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders
				.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(inputJson))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		Plano planoCriado = super.mapFromJson(content, Plano.class);
		assertEquals(content, planoCriado);
	}

	@Test
	public void updateProduct() throws Exception {
		String uri = "/plano";
		Tipo tipo = new Tipo(1,"Controle");
		Plano plano = new Plano(99999l,"021",100,200,200,tipo,"vivo");
		String inputJson = super.mapToJson(plano);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Plano planoCriado = super.mapFromJson(content, Plano.class);
		assertEquals(content, planoCriado);
	}

	@Test
	public void deveDeletarUmPlano() throws Exception {
		String uri = "/plano?id=99999";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "Plano deletado com Sucesso.");
	}
}
