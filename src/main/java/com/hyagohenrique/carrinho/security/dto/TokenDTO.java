package com.hyagohenrique.carrinho.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenDTO {

	private String access_token;
	private long expires_in;


}
