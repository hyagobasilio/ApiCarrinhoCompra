package com.hyagohenrique.carrinho.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hyagohenrique.carrinho.dto.CarrinhoDTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "carrinhos")
public class Carrinho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "carrinho")
    private Set<CarrinhoItem> itens;

	public CarrinhoDTO convertParaDTO() {
        CarrinhoDTO dto =  new CarrinhoDTO(id);
        dto.setItens(this.itens.stream().map(i -> i.converterParaResponseDTO()).collect(Collectors.toList()));
        return dto;
	}


    /* private List<Desconto> descontos;
    private BigDecimal valorTotal;
    private Boolean isVenda; */


    
}