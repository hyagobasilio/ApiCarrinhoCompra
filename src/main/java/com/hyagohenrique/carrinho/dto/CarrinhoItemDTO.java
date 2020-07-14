package com.hyagohenrique.carrinho.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.hyagohenrique.carrinho.model.Carrinho;
import com.hyagohenrique.carrinho.model.CarrinhoItem;
import com.hyagohenrique.carrinho.model.Produto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarrinhoItemDTO {
    
    private Long id;
    @NotNull(message = "Informe o id do produto que deseja adicionar")
    private Long idProduto;
    @NotNull(message = "Informe a quantidade")
    private BigDecimal quantidade;

    public CarrinhoItem converterParaEntidade() {
        CarrinhoItem ci = new CarrinhoItem();

        Produto p = new Produto();
        p.setId(idProduto);
        ci.setProduto(p);

        ci.setQuantidade(quantidade);
        return ci;
    }
}