package com.hyagohenrique.carrinho.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCarrinho {
    
    private Carrinho carrinho;
    private Produto produto;
    private BigDecimal quantidade;

}
