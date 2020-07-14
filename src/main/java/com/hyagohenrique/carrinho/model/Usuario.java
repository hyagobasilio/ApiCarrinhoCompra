package com.hyagohenrique.carrinho.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hyagohenrique.carrinho.dto.ClienteDTO;
import com.hyagohenrique.carrinho.dto.UsuarioDTO;
import com.hyagohenrique.carrinho.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "usuarios")
@Entity
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    
    @Column(unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role; 

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario() {
	}

	public UsuarioDTO converterParaDTO() {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setFirstname(nome);
        dto.setLastname("Sobrenome");
        dto.setUsername(email);
        return dto;
    }
	public ClienteDTO converterParaClienteDTO() {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(id);
        dto.setNome(nome);
        dto.setEmail(email);
        return dto;
    }
}