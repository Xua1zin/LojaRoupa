package com.atividade_roupas.atividade_roupas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atividade_roupas.atividade_roupas.entities.ProdutoEntity;
import com.atividade_roupas.atividade_roupas.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping("/save")
	public ProdutoEntity save(@RequestBody ProdutoEntity produtoEntity) {
		return produtoService.save(produtoEntity);
	}
	
	@GetMapping("/findById/{id}")
	public ProdutoEntity findById(@PathVariable Long id) {
		return produtoService.findById(id);
	}
	
	@GetMapping("/findAll")
	public List<ProdutoEntity> findAll(){
		return produtoService.findAll();
	}
	
	public List<ProdutoEntity> produtosMaisCaros(){
		return produtoService.produtosMaisCaros();
	}
}
