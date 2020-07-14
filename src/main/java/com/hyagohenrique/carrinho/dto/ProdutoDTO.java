package com.hyagohenrique.carrinho.dto;

import java.math.BigDecimal;

import com.hyagohenrique.carrinho.model.Categoria;
import com.hyagohenrique.carrinho.model.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Long idCategoria;

    public Produto converterParaEntidade() {
        Produto p = new Produto();
        p.setId(id);
        p.setNome(nome);
        Categoria c = new Categoria();
        c.setId(idCategoria);
        p.setCategoria(c);
        p.setPreco(preco);

        return p;
    }
}