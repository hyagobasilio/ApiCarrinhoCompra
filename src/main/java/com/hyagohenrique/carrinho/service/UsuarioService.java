package com.hyagohenrique.carrinho.service;

import java.util.Optional;

import com.hyagohenrique.carrinho.irepository.IUsuarioRepository;
import com.hyagohenrique.carrinho.iservice.IUsuarioService;
import com.hyagohenrique.carrinho.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario u) {
        return this.usuarioRepository.save(u);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return this.usuarioRepository.findByEmail(email);
    }
   
}