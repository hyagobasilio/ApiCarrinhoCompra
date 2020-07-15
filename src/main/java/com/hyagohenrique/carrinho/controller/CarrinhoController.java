package com.hyagohenrique.carrinho.controller;

import com.hyagohenrique.carrinho.dto.CarrinhoDTO;
import com.hyagohenrique.carrinho.iservice.ICarrinhoService;
import com.hyagohenrique.carrinho.response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("carrinho")
public class CarrinhoController {

    @Autowired
    private ICarrinhoService carrinhoService;
    
    @GetMapping
    public ResponseEntity<Response<CarrinhoDTO>> getMethodName() {
        Response<CarrinhoDTO> body = new Response<>();
        body.setData(this.carrinhoService.getCarrinhoDoUsuarioLogado().convertParaDTO());

        return ResponseEntity.ok(body);
    }
    
}