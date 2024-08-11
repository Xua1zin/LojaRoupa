package com.atividade_roupas.atividade_roupas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividade_roupas.atividade_roupas.entities.FuncionarioEntity;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long>{

}
