package com.hyagohenrique.carrinho.irepository;

import com.hyagohenrique.carrinho.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {
    
}