package com.hyagohenrique.carrinho.iservice;

import java.util.List;

import com.hyagohenrique.carrinho.model.Carrinho;
import com.hyagohenrique.carrinho.model.Usuario;

public interface ICarrinhoService {
    
    Carrinho salvar(Usuario usuario);

    Carrinho getCarrinhoPorId(Long id);

    Carrinho getCarrinhoDoUsuarioLogado();
    
    List<Carrinho> listCarrinhosPorIdDoUsuario(Long idUsuario);
}