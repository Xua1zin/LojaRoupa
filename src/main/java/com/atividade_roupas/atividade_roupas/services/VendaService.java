package com.atividade_roupas.atividade_roupas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atividade_roupas.atividade_roupas.entities.ClienteEntity;
import com.atividade_roupas.atividade_roupas.entities.ProdutoEntity;
import com.atividade_roupas.atividade_roupas.entities.FuncionarioEntity;
import com.atividade_roupas.atividade_roupas.entities.VendaEntity;
import com.atividade_roupas.atividade_roupas.repositories.ClienteRepository;
import com.atividade_roupas.atividade_roupas.repositories.FuncionarioRepository;
import com.atividade_roupas.atividade_roupas.repositories.ProdutoRepository;
import com.atividade_roupas.atividade_roupas.repositories.VendaRepository;

@Service
public class VendaService {
	@Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public VendaEntity findById(Long id){
        try {
            return vendaRepository.findById(id).orElseThrow();
        }catch (Exception e){
            return new VendaEntity();
        }
    }

    public List<VendaEntity> findAll(){
        return vendaRepository.findAll();
    }
    
    public List<VendaEntity> maioresVendas(){
    	return vendaRepository.maioresVendas();
    }

    public VendaEntity save(VendaEntity vendaEntity) {
        Optional<ClienteEntity> cliente = clienteRepository.findById(vendaEntity.getCliente().getId());
        vendaEntity.setCliente(cliente.get());

        Optional <FuncionarioEntity> funcionario= funcionarioRepository.findById(vendaEntity.getFuncionario().getId());
        vendaEntity.setFuncionario(funcionario.get());

        double total = 0.0;
        List<ProdutoEntity> produtosEscolhidos = new ArrayList<>();
        for (ProdutoEntity produto : vendaEntity.getProduto()) {
            ProdutoEntity produtoEncontrado = produtoRepository.findById(produto.getId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            produtosEscolhidos.add(produtoEncontrado);
            total += produtoEncontrado.getPreco();
        }
        vendaEntity.setProduto(produtosEscolhidos);
        vendaEntity.setTotal(total);

        return this.vendaRepository.save(vendaEntity);
    }

    
    public List<VendaEntity> findByNomeCliente(String nomeCliente){
    	return vendaRepository.findByNomeCliente(nomeCliente);
    }
    
    public List<VendaEntity> findByNomeFuncionario(String nomeFuncionario){
    	return vendaRepository.findByNomeFuncionario(nomeFuncionario);
    }
}
