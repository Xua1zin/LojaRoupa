package com.atividade_roupas.atividade_roupas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade_roupas.atividade_roupas.entities.FuncionarioEntity;
import com.atividade_roupas.atividade_roupas.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioEntity findById(Long id){
        try {
            return funcionarioRepository.findById(id).orElseThrow();
        }catch (Exception e){
            return new FuncionarioEntity();
        }
    }

    public List<FuncionarioEntity> findAll(){
        return funcionarioRepository.findAll();
    }

    public FuncionarioEntity save(FuncionarioEntity  funcionarioEntity){
        return funcionarioRepository.save(funcionarioEntity);
    }

}
