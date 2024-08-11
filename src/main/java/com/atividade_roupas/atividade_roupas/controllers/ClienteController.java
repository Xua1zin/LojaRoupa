package com.atividade_roupas.atividade_roupas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade_roupas.atividade_roupas.entities.ClienteEntity;
import com.atividade_roupas.atividade_roupas.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/save")
	public ClienteEntity save(@RequestBody ClienteEntity clienteEntity) {
		return clienteService.saveCliente(clienteEntity);
	}
	
	@GetMapping("/findById/{id}")
	public ClienteEntity findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	@GetMapping("/findAll")
	public List<ClienteEntity> findAll() {
		return clienteService.findAll();
	}
	
	@GetMapping("/entre18e35anos")
	public List<ClienteEntity> entre18e35anos(){
		return clienteService.entre18e35anos();
	}
}
