package com.hyagohenrique.carrinho.controller;

import javax.validation.Valid;

import com.hyagohenrique.carrinho.dto.DescontoDTO;
import com.hyagohenrique.carrinho.iservice.IDescontoService;
import com.hyagohenrique.carrinho.iservice.IUsuarioService;
import com.hyagohenrique.carrinho.model.Desconto;
import com.hyagohenrique.carrinho.response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("desconto")
public class DescontoController {
    
    @Autowired IDescontoService descontoService;


    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Response<DescontoDTO>> cadastrar(@Valid @RequestBody DescontoDTO dto, BindingResult result) {
        Response<DescontoDTO> body = new Response<>();
        if(result.hasErrors()) {
            result.getAllErrors().stream()
            .forEach(e -> body.getErrors().add(e.getDefaultMessage()));
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }
        Desconto desconto = dto.converterParaEntidade();
        desconto = this.descontoService.cadastrar(desconto);
        
        body.setData(desconto.converterParaDTO());
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
    
}