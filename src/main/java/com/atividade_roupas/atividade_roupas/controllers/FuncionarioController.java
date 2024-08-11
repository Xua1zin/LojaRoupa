package com.atividade_roupas.atividade_roupas.controllers;

import java.util.List;

import com.atividade_roupas.atividade_roupas.entities.VendaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade_roupas.atividade_roupas.entities.FuncionarioEntity;
import com.atividade_roupas.atividade_roupas.services.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping("/save")
	public ResponseEntity<FuncionarioEntity> save(@RequestBody FuncionarioEntity funcionarioEntity) {
		FuncionarioEntity funcionario = funcionarioService.save(funcionarioEntity);
		return new ResponseEntity<>(funcionario, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<FuncionarioEntity> findById(@PathVariable Long id) {
		FuncionarioEntity funcionario = funcionarioService.findById(id);
		return new ResponseEntity<>(funcionario, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<FuncionarioEntity>> findAll(){
		List<FuncionarioEntity> funcionario = funcionarioService.findAll();
		return new ResponseEntity<>(funcionario, HttpStatus.OK);
	}
	
}
