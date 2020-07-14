package com.hyagohenrique.carrinho.dto;

import javax.validation.constraints.NotEmpty;

import com.hyagohenrique.carrinho.model.Categoria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {
    
    private Long id;
    @NotEmpty(message = "Informe o nome da categoria!")
    private String nome;


    public Categoria converterParEntidade() {
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.setNome(nome);
        return categoria;
    }
}