package com.atividade_roupas.atividade_roupas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade_roupas.atividade_roupas.entities.ProdutoEntity;
import com.atividade_roupas.atividade_roupas.repositories.ProdutoRepository;


@Service
public class ProdutoService {
	@Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoEntity findById(Long id){
        try {
            return produtoRepository.findById(id).orElseThrow();
        }catch (Exception e){
            return new ProdutoEntity();
        }
    }

    public List<ProdutoEntity> findAll(){
        return produtoRepository.findAll();
    }

    public ProdutoEntity save(ProdutoEntity produtoEntity){
        return produtoRepository.save(produtoEntity);
    }

    public List<ProdutoEntity> produtosMaisCaros(){
    	return produtoRepository.produtosMaisCaros();
    }
}
