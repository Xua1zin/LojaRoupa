package com.atividade_roupas.atividade_roupas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<ProdutoEntity> save(@RequestBody ProdutoEntity produtoEntity) {
		ProdutoEntity produto = produtoService.save(produtoEntity);
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<ProdutoEntity> findById(@PathVariable Long id) {
		ProdutoEntity produto = produtoService.findById(id);
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ProdutoEntity>> findAll(){
		List<ProdutoEntity> produto = produtoService.findAll();
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}

	@GetMapping("/produtosMaisCaros")
	public ResponseEntity<List<ProdutoEntity>> produtosMaisCaros(){
		List<ProdutoEntity> produto = produtoService.produtosMaisCaros();
		return new ResponseEntity<>(produto, HttpStatus.OK);
	}
}
