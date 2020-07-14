package com.hyagohenrique.carrinho.dto;

import javax.validation.constraints.NotNull;

import com.hyagohenrique.carrinho.enums.Role;
import com.hyagohenrique.carrinho.model.Usuario;
import com.hyagohenrique.carrinho.utils.Bcrypt;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    
    private Long id;
    @NotNull
	@Length(min=3, max= 50, message="O nome deve conter entre 3 e 50 caracteres")
    private String nome;
    @Email(message="Email inválido")
    private String email;
    @NotNull
	@Length(min=6, message="A senha deve conter no mínimo 6 caracteres")
    private String senha;

    public Usuario converterParaEntidade() {
        Usuario u = new Usuario();
        u.setRole(Role.ROLE_USER);
        u.setEmail(email);
        u.setNome(nome);
        u.setPassword(Bcrypt.getHash(senha));
        return u;
    }
}