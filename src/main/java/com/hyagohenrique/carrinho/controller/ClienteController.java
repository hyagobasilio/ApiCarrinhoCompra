package com.hyagohenrique.carrinho.controller;

import java.util.List;

import com.hyagohenrique.carrinho.dto.ClienteDTO;
import com.hyagohenrique.carrinho.iservice.IUsuarioService;
import com.hyagohenrique.carrinho.model.Usuario;
import com.hyagohenrique.carrinho.response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private IUsuarioService usuarioService;
    
    @PostMapping
    public ResponseEntity<Response<ClienteDTO>> salvar(@RequestBody ClienteDTO dto, BindingResult result) {
        Response<ClienteDTO> response = new Response<>();
        if(result.hasErrors()) {
            result.getAllErrors().forEach(e -> {
                response.getErrors().add(e.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        Usuario usuario = this.usuarioService.save(dto.converterParaEntidade());
        response.setData(usuario.converterParaClienteDTO());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}