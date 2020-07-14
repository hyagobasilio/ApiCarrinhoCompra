package com.hyagohenrique.carrinho.irepository;

import com.hyagohenrique.carrinho.model.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<Categoria, Long> {
    
}