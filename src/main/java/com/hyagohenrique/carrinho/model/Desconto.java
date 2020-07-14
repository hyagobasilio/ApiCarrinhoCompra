package com.hyagohenrique.carrinho.model;

import java.math.BigDecimal;

import com.hyagohenrique.carrinho.enums.TipoDesconto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Desconto {
    
    private Long id;
    private String codigo;
    private BigDecimal valor;
    private TipoDesconto dipoDesconto;
    private Categoria categoria;
    private Boolean isAcumulativo;
}