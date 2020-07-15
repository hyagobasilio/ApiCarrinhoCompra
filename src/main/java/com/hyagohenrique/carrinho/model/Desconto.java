package com.hyagohenrique.carrinho.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hyagohenrique.carrinho.dto.DescontoDTO;
import com.hyagohenrique.carrinho.enums.TipoDesconto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "descontos")
public class Desconto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String codigo;
    @Column
    private BigDecimal valor;
    @Column(name = "tipo_desconto")
    private TipoDesconto tipoDesconto; // percentual / fixo
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;    // se null , desconto Para Carrinho
    @Column(name = "is_acumulativo", columnDefinition = "BOOLEAN")
    private Boolean isAcumulativo;

    public DescontoDTO converterParaDTO() {
        DescontoDTO dto = new DescontoDTO();
        dto.setId(id);
        dto.setCodigo(codigo);
        dto.setValor(valor);
        dto.setTipoDesconto(tipoDesconto.getValue());
        dto.setIdCategoria(categoria.getId());
        dto.setIsAcumulativo(isAcumulativo);
        return dto;
    }
}