package com.atividade_roupas.atividade_roupas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public FuncionarioEntity save(@RequestBody FuncionarioEntity funcionarioEntity) {
		return funcionarioService.save(funcionarioEntity);
	}
	
	@GetMapping("/findById/{id}")
	public FuncionarioEntity findById(@PathVariable Long id) {
		return funcionarioService.findById(id);
	}
	
	@GetMapping("/findAll")
	public List<FuncionarioEntity> findAll(){
		return funcionarioService.findAll();
	}
	
}
