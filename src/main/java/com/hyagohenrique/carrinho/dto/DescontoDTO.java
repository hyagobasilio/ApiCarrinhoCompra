package com.hyagohenrique.carrinho.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.hyagohenrique.carrinho.enums.TipoDesconto;
import com.hyagohenrique.carrinho.model.Categoria;
import com.hyagohenrique.carrinho.model.Desconto;
import com.hyagohenrique.carrinho.utils.builder.DescontoBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DescontoDTO {
    
    private Long id;
    private String codigo;
    @NotNull(message = "Informe o valor do desconto")
    private BigDecimal valor;
    @NotNull(message = "Informe o tipo")
    @Pattern(regexp="^(PERCENTUAL|FIXO)$", message = "Para o tipo somente são aceitos os valores PERCENTUAL ou FIXO")
    private String tipoDesconto;
    private Long idCategoria;
    private Boolean isAcumulativo;

    public Desconto converterParaEntidade() {
        return new DescontoBuilder(valor, TipoDesconto.getEnum(tipoDesconto), isAcumulativo)
                .setCategoria(idCategoria)
                .setCodigo(codigo)
                .build();
    }
}