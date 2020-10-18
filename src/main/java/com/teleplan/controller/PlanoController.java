package com.teleplan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.teleplan.model.Plano;
import com.teleplan.service.PlanoService;

@Controller
public class PlanoController {

	@Autowired
	private PlanoService planoService;

	/* Método de inserção de um plano
	 * @param: String ddd
	 * @param: int minutos
	 * @param: int franquiaDeInternet
	 * @param: double valor
	 * @param: String operadora
	 * @param: String tipo
	 * @Return: Plano 
	 * */	
	@PostMapping("/plano")
	public ResponseEntity<Plano> save(@RequestParam String ddd,@RequestParam int minutos,
			@RequestParam int franquiaDeInternet, @RequestParam double valor,@RequestParam String operadora,@RequestParam String tipo){
		return ResponseEntity.ok(planoService.save(ddd,minutos,franquiaDeInternet, valor, tipo, operadora));
	}
	
	/* Método de atualização de um plano
	 * @param: long id
	 * @param: String ddd
	 * @param: int minutos
	 * @param: int franquiaDeInternet
	 * @param: double valor
	 * @param: String operadora
	 * @param: String tipo
	 * @Return: Plano 
	 * */	
	@PutMapping("/plano")
	public ResponseEntity<Plano> update(@RequestParam long id,@RequestParam String ddd,@RequestParam int minutos,
			@RequestParam int franquiaDeInternet, @RequestParam double valor,@RequestParam String operadora,@RequestParam String tipo){
		return ResponseEntity.ok(planoService.update(id,ddd,minutos,franquiaDeInternet, valor, tipo, operadora));
	}
	
	/* Método de deleção de um plano
	 * @param: long id
	 * @Return: void 
	 * */	
	@DeleteMapping("/plano")
	public ResponseEntity<String> delete(@RequestParam long id){
		planoService.deleteById(id);
		return ResponseEntity.ok("Plano deletado com Sucesso.");
	}
	
	/* Método de busca de planos pelo codigo DDD
	 * @param: String ddd
	 * @Return: List<Plano> 
	 * */	
	@GetMapping("/plano/buscaPeloDDD")
	public ResponseEntity<List<Plano>> findByCodigoDDD(@RequestParam String ddd){
		return ResponseEntity.ok(planoService.findByCodigoDDD(ddd));
	}

	/* Método de busca de planos pelo codigo DDD e pela operadora
	 * @param: String ddd
	 * @param: String operadora
	 * @Return: List<Plano> 
	 * */	
	@GetMapping("/plano/buscaPeloDDDEOperadora")
	public ResponseEntity<List<Plano>> findByCodigoDDDAndOperadoraAllIgnoreCase(@RequestParam String ddd, @RequestParam String operadora){
		return ResponseEntity.ok(planoService.findByCodigoDDDAndOperadoraAllIgnoreCase(ddd, operadora));
	}

	/* Método de busca de planos pelo codigo DDD e pelo Id do plano
	 * @param: String ddd
	 * @param: long id 
	 * @Return: Plano 
	 * */	
	@GetMapping("/plano/buscaPeloDDDEId")
	public ResponseEntity<Plano> findByCodigoDDDAndId(@RequestParam String ddd, @RequestParam long id){
		Optional<Plano> plano = planoService.findByCodigoDDDAndId(ddd, id);
		if(plano.isEmpty()) 
			return ResponseEntity.ok(null);
		return ResponseEntity.ok(plano.get());
	}

	/* Método de busca de planos pelo codigo DDD e pela descricao do tipo
	 * @param: String ddd
	 * @param: String tipo 
	 * @Return: Plano 
	 * */	
	@GetMapping("/plano/buscaPeloDDDETipo")
	public ResponseEntity<List<Plano>> findByCodigoDDDAndTipoAllIgnoreCase(@RequestParam String ddd, @RequestParam String tipo){
		return ResponseEntity.ok(planoService.findByCodigoDDDAndTipoAllIgnoreCase(ddd, tipo));
	}
}
