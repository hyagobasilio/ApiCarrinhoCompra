package com.hyagohenrique.carrinho.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Carrinho {
    
    private Long id;
    private Usuario usuario;
    private List<ItemCarrinho> itens = new ArrayList<>();
    private List<Desconto> descontos;
    private BigDecimal valorTotal;
    private Boolean isVenda;


    
}