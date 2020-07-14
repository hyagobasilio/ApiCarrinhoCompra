package com.hyagohenrique.carrinho.irepository;

import java.util.List;

import com.hyagohenrique.carrinho.model.CarrinhoItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarrinhoItemRespository extends JpaRepository<CarrinhoItem, Long> {

    List<CarrinhoItem> findAllByCarrinhoId(Long id);
    
}