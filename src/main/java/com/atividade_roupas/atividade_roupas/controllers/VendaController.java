package com.atividade_roupas.atividade_roupas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public VendaEntity save(@RequestBody VendaEntity vendaEntity) {
		return vendaService.save(vendaEntity);
	}
	
	@GetMapping("/findById/{id}")
	public VendaEntity findById(@PathVariable Long id) {
		return vendaService.findById(id);
	}
	
	@GetMapping("/findAll")
	public List<VendaEntity> findAll(){
		return vendaService.findAll();
	}
	
	@GetMapping("/findByNomeCliente/")
	public List<VendaEntity> findByNomeCliente(@RequestParam String nomeCliente){
		return vendaService.findByNomeCliente(nomeCliente);
	}
	
	@GetMapping("/findByNomeFuncionario")
	public List<VendaEntity> findByNomeFuncionario(@RequestParam String nomeFuncionario){
		return vendaService.findByNomeFuncionario(nomeFuncionario);
	}
	
	@GetMapping("/maioresVendas")
	public List<VendaEntity> maioresVendas(){
		return vendaService.maioresVendas();
	}
}
