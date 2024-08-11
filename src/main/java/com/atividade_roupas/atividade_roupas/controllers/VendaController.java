package com.atividade_roupas.atividade_roupas.controllers;

import java.util.List;

import com.atividade_roupas.atividade_roupas.entities.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atividade_roupas.atividade_roupas.entities.VendaEntity;
import com.atividade_roupas.atividade_roupas.services.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {
	@Autowired
	private VendaService vendaService;
	
	@PostMapping("/save")
	public ResponseEntity<VendaEntity> save(@RequestBody VendaEntity vendaEntity) {
		VendaEntity venda = vendaService.save(vendaEntity);
		return new ResponseEntity<>(venda, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<VendaEntity> findById(@PathVariable Long id) {
		VendaEntity venda = vendaService.findById(id);
		return new ResponseEntity<>(venda, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<VendaEntity>> findAll(){
		List<VendaEntity> venda = vendaService.findAll();
		return new ResponseEntity<>(venda, HttpStatus.OK);
	}
	
	@GetMapping("/findByNomeCliente")
	public ResponseEntity<List<VendaEntity>> findByNomeCliente(@RequestParam String nomeCliente){
		List<VendaEntity> venda = vendaService.findByNomeCliente(nomeCliente);
		return new ResponseEntity<>(venda, HttpStatus.OK);
	}
	
	@GetMapping("/findByNomeFuncionario")
	public ResponseEntity<List<VendaEntity>> findByNomeFuncionario(@RequestParam String nomeFuncionario){
		List<VendaEntity> venda = vendaService.findByNomeFuncionario(nomeFuncionario);
		return new ResponseEntity<>(venda, HttpStatus.OK);
	}
	
	@GetMapping("/maioresVendas")
	public ResponseEntity<List<VendaEntity>> maioresVendas(){
		List<VendaEntity> venda = vendaService.maioresVendas();
		return new ResponseEntity<>(venda, HttpStatus.OK);
	}
}
