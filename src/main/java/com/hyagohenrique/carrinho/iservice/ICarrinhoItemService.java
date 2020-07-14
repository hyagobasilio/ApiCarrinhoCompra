package com.hyagohenrique.carrinho.iservice;

import java.util.List;

import com.hyagohenrique.carrinho.model.CarrinhoItem;

public interface ICarrinhoItemService {
    
    CarrinhoItem salvar(CarrinhoItem carrinhoItem);

    List<CarrinhoItem> listrarItensBuscandoPorIdDoCarrinho(Long id);

    void removerItem(Long id);
}