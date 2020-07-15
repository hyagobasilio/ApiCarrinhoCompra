package com.hyagohenrique.carrinho.service;

import com.hyagohenrique.carrinho.irepository.IDescontoRepository;
import com.hyagohenrique.carrinho.iservice.IDescontoService;
import com.hyagohenrique.carrinho.model.Desconto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescontoService implements IDescontoService {
    
    @Autowired
    private IDescontoRepository descontoRespository;

    @Override
    public Desconto cadastrar(Desconto desconto) {
        return this.descontoRespository.save(desconto);
    }
    
}