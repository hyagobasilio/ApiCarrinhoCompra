package com.hyagohenrique.carrinho.iservice;

import java.util.List;

import com.hyagohenrique.carrinho.model.Categoria;

public interface ICategoriaService {
    

    public Categoria salvar(Categoria categoria);

    public List<Categoria> listarCategorias();

    public void remover(Long id);
}