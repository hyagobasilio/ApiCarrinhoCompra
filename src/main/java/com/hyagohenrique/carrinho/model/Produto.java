package com.hyagohenrique.carrinho.model;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Produto implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 4763499263634710958L;

    private Long id;
    private String nome;
    private BigDecimal preco;

    public Produto(String nome) {
        this.nome = nome;
    }
 }