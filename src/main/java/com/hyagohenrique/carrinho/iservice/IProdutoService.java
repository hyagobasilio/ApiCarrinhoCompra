package com.hyagohenrique.carrinho.iservice;

import java.util.List;

import com.hyagohenrique.carrinho.model.Produto;

public interface IProdutoService {
    
    Produto salvar(Produto produto);

    List<Produto> getLista();
}