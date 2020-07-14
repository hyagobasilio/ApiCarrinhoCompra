package com.hyagohenrique.carrinho.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hyagohenrique.carrinho.dto.CategoriaDTO;
import com.hyagohenrique.carrinho.dto.ProdutoDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "produtos")
public class Produto implements Serializable {
    
    /**
     *
     */
    private static final long serialVersionUID = 4763499263634710958L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    

    public Produto(String nome) {
        this.nome = nome;
    }

    public ProdutoDTO converterParaDTO() {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setId(id);
        dto.setNome(nome);
        dto.setIdCategoria(categoria.getId());
        dto.setPreco(preco);
        return dto;
    }
 }