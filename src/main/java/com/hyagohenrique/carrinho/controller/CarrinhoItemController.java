package com.hyagohenrique.carrinho.controller;

import javax.validation.Valid;

import com.hyagohenrique.carrinho.dto.CarrinhoItemDTO;
import com.hyagohenrique.carrinho.dto.CarrinhoItemResponseDTO;
import com.hyagohenrique.carrinho.iservice.ICarrinhoItemService;
import com.hyagohenrique.carrinho.response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carrinho-item")
public class CarrinhoItemController {

    @Autowired
    private ICarrinhoItemService carrinhoItemService;

    @PostMapping
    public ResponseEntity<Response<CarrinhoItemResponseDTO>> adicionarItemAoCarrinho(@Valid @RequestBody CarrinhoItemDTO dto, BindingResult result) {

        Response<CarrinhoItemResponseDTO> response = new Response<>();
        if(result.hasErrors()) {
            result.getAllErrors().forEach(e -> {
                response.getErrors().add(e.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        CarrinhoItemResponseDTO data = this.carrinhoItemService.salvar(dto.converterParaEntidade()).converterParaResponseDTO();
        response.setData(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deletar(@PathVariable("id") Long id) {
        Response<String> body = new Response<>();

        this.carrinhoItemService.removerItem(id);

        body.setData("Item removido com sucesso!");
    
        return ResponseEntity.ok(body);
    }
    
}