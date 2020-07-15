package com.hyagohenrique.carrinho.utils.builder;

import java.math.BigDecimal;

import com.hyagohenrique.carrinho.enums.TipoDesconto;
import com.hyagohenrique.carrinho.model.Categoria;
import com.hyagohenrique.carrinho.model.Desconto;

public class DescontoBuilder {

    private Desconto desconto;
    
    private DescontoBuilder() {}

    public DescontoBuilder(BigDecimal valor, TipoDesconto tipoDesconto, Boolean isAcumulativo) {
        this.desconto = new Desconto();
        this.desconto.setValor(valor);
        this.desconto.setTipoDesconto(tipoDesconto);
        this.desconto.setIsAcumulativo(isAcumulativo);
    }

    public DescontoBuilder setCodigo(String codigo) {
        this.desconto.setCodigo(codigo);
        return this;
    }

    public DescontoBuilder setCategoria(Long idCategoria) {
        Categoria c = new Categoria();
        c.setId(idCategoria);
        this.desconto.setCategoria(c);
        return this;
    }

    public Desconto build() {
        return this.desconto;
    }
}