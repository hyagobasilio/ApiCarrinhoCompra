package com.hyagohenrique.carrinho.exception;

public class FeriasNaoDisponivelException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public FeriasNaoDisponivelException(String msg) {
        super(msg);
    }
}