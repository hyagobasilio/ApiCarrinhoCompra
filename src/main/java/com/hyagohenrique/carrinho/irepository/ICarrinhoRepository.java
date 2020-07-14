package com.hyagohenrique.carrinho.irepository;

import java.util.List;

import com.hyagohenrique.carrinho.model.Carrinho;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarrinhoRepository extends JpaRepository<Carrinho, Long> {
    List<Carrinho> findAllByUsuarioId(Long idUsuario);
}