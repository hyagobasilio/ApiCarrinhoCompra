package com.hyagohenrique.carrinho.enums;

public enum TipoDesconto {
    PERCENTUAL("PERCENTUAL"), FIXO("FIXO");

    private final String value;

	TipoDesconto(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static TipoDesconto getEnum(String value) {
		for(TipoDesconto t : values()) {
			if(value.equals(t.getValue())) {
				return t;
			}
		}
		return null;
	}
}