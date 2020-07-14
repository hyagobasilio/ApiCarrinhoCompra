package com.hyagohenrique.carrinho.iservice;

import java.util.Optional;

import com.hyagohenrique.carrinho.model.Usuario;

public interface IUsuarioService {
    Usuario save(Usuario u);
	
	Optional<Usuario> findByEmail(String email);
}