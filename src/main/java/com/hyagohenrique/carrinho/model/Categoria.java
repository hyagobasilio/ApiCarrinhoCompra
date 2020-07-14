package com.hyagohenrique.carrinho.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categoria implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nome;
}