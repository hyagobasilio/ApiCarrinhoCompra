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

import com.hyagohenrique.carrinho.dto.CarrinhoItemResponseDTO;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "carrinho_item")
public class CarrinhoItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Carrinho carrinho;
    @ManyToOne
    private Produto produto;
    @Column
    private BigDecimal quantidade;
    @Column
    private BigDecimal valorVenda;


    public BigDecimal subTotal() {
        return this.quantidade.multiply(valorVenda);
    }

    public CarrinhoItemResponseDTO converterParaResponseDTO() {
        return new CarrinhoItemResponseDTO(id, produto.getNome(), valorVenda, quantidade, subTotal());
    }

}
