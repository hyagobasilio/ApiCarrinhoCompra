package com.hyagohenrique.carrinho.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.hyagohenrique.carrinho.dto.CategoriaDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categorias")
public class Categoria implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8557720096334503974L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nome;


    public CategoriaDTO converterParaDTO() {
        CategoriaDTO dto = new CategoriaDTO();

        dto.setId(id);
        dto.setNome(nome);
        return dto;
    }
}