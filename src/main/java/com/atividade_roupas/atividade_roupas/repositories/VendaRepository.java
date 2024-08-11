package com.atividade_roupas.atividade_roupas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atividade_roupas.atividade_roupas.entities.VendaEntity;

public interface VendaRepository extends JpaRepository<VendaEntity, Long>{
	@Query(value = "SELECT v.* FROM venda AS v JOIN cliente AS c ON v.cliente_id = c.id WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nomeCliente, '%'))", nativeQuery = true)
    List<VendaEntity> findByNomeCliente(@Param("nomeCliente") String nomeCliente);

    @Query(value = "SELECT v.* FROM venda AS v JOIN funcionario AS f ON v.funcionario_id = f.id WHERE LOWER(f.nome) LIKE LOWER(CONCAT('%', :nomeFuncionario, '%'))", nativeQuery = true)
    List<VendaEntity> findByNomeFuncionario(@Param("nomeFuncionario") String nomeFuncionario);
    
	@Query(value = "SELECT * FROM venda ORDER BY total DESC LIMIT 10", nativeQuery = true)
	List<VendaEntity> maioresVendas();
}
