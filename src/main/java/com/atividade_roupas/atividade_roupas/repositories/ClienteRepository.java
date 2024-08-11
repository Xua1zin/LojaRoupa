package com.atividade_roupas.atividade_roupas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.atividade_roupas.atividade_roupas.entities.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{
	@Query(value = "SELECT * FROM cliente WHERE idade BETWEEN 18 AND 35", nativeQuery = true)
	List<ClienteEntity> entre18e35anos();
}
