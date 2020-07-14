package com.hyagohenrique.carrinho.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoDTO {

    public CarrinhoDTO(Long id) {
        this.idCarrinho = id;
    }
    
    private Long idCarrinho;

    private List<CarrinhoItemResponseDTO> itens;



}