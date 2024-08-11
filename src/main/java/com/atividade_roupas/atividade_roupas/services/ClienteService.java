package com.atividade_roupas.atividade_roupas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade_roupas.atividade_roupas.entities.ClienteEntity;
import com.atividade_roupas.atividade_roupas.repositories.ClienteRepository;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteEntity findById(Long id){
        try {
            return clienteRepository.findById(id).orElseThrow();
        }catch (Exception e){
            return new ClienteEntity();
        }
    }

    public List<ClienteEntity> findAll(){
        return clienteRepository.findAll();
    }

    public ClienteEntity save(ClienteEntity  clienteEntity){
        return clienteRepository.save(clienteEntity);	
    }
    
    public List<ClienteEntity> entre18e35anos(){
    	return this.clienteRepository.entre18e35anos();
    }
}
