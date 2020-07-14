package com.hyagohenrique.carrinho.service;

import java.util.List;

import com.hyagohenrique.carrinho.exception.NotFoundException;
import com.hyagohenrique.carrinho.irepository.IProdutoRepository;
import com.hyagohenrique.carrinho.iservice.IProdutoService;
import com.hyagohenrique.carrinho.model.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService implements IProdutoService {

    @Autowired
    private IProdutoRepository produtoRepository;


    @Override
    public Produto salvar(Produto produto) {
        return this.produtoRepository.save(produto);
    }

    @Override
    public List<Produto> getLista() {
        return this.produtoRepository.findAll();
    }
    @Override
    public void remover(Long id) {
        this.produtoRepository.findById(id).orElseThrow(() -> new NotFoundException("Recurso com id: " + id + " não encontrado!"));
        
        this.produtoRepository.deleteById(id);
    }
    
}