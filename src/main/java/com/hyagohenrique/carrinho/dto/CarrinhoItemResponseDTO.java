package com.hyagohenrique.carrinho.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoItemResponseDTO {
    private Long idItem;
    private String nomeProduto;
    private BigDecimal valor;
    private BigDecimal quantidade;
    private BigDecimal valorTotalItem;

}
