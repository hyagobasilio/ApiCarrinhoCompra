package com.hyagohenrique.carrinho.security;

import java.util.ArrayList;
import java.util.List;

import com.hyagohenrique.carrinho.enums.Role;
import com.hyagohenrique.carrinho.model.Usuario;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.NoArgsConstructor;

@NoArgsConstructor	
public class JwtUserFactory {

	public static JwtUser create(Usuario user) {
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), createGrantedAuthorities(user.getRole()));
	}
	
	private static List<GrantedAuthority> createGrantedAuthorities(Role role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.toString()));
		return authorities;
	}

}
