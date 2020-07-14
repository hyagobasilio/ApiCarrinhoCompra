package com.hyagohenrique.carrinho.security.service;

import java.util.Optional;

import com.hyagohenrique.carrinho.iservice.IUsuarioService;
import com.hyagohenrique.carrinho.model.Usuario;
import com.hyagohenrique.carrinho.security.JwtUserFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	Optional<Usuario> user = this.userService.findByEmail(email);

		if (user.isPresent()) {
			return JwtUserFactory.create(user.get());
		}

		throw new UsernameNotFoundException("Email não encontrado.");
	}

}