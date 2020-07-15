package com.hyagohenrique.carrinho.irepository;

import com.hyagohenrique.carrinho.model.Desconto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IDescontoRepository extends JpaRepository<Desconto, Long> {
    
}