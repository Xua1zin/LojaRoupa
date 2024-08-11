package com.atividade_roupas.atividade_roupas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ClienteEntity> save(@RequestBody ClienteEntity clienteEntity) {
		ClienteEntity cliente = clienteService.save(clienteEntity);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<ClienteEntity> findById(@PathVariable Long id) {
		ClienteEntity cliente = clienteService.findById(id);
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ClienteEntity>> findAll() {
		List<ClienteEntity> cliente = clienteService.findAll();
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/entre18e35anos")
	public ResponseEntity<List<ClienteEntity>> entre18e35anos(){
		List<ClienteEntity> cliente = clienteService.entre18e35anos();
		return new ResponseEntity<>(cliente, HttpStatus.OK);
	}
}
