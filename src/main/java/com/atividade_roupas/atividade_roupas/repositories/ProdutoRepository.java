package com.atividade_roupas.atividade_roupas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atividade_roupas.atividade_roupas.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long>{
	@Query(value = "SELECT * FROM produtos ORDER BY valor DESC LIMIT 10", nativeQuery = true)
	List<ProdutoEntity> produtosMaisCaros();	
}
