package com.hyagohenrique.carrinho.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.hyagohenrique.carrinho.dto.ProdutoDTO;
import com.hyagohenrique.carrinho.iservice.IProdutoService;
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
@RequestMapping("produto")
public class ProdutoController {
    

    @Autowired
    private IProdutoService produtoService;

    @GetMapping
    public ResponseEntity<Response<List<ProdutoDTO>>> listarProdutos() {
        Response<List<ProdutoDTO>> body = new Response<>();

        List<ProdutoDTO> produtos = this.produtoService.getLista().stream()
            .map(i -> i.converterParaDTO())
            .collect(Collectors.toList());
        
            body.setData(produtos);

        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<Response<ProdutoDTO>> salvar(@Valid @RequestBody ProdutoDTO dto, BindingResult result) {
        Response<ProdutoDTO> body = new Response<>();

        if(result.hasErrors()) {
            result.getAllErrors().stream()
            .forEach(e -> body.getErrors().add(e.getDefaultMessage()));
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        }

        dto = this.produtoService.salvar(dto.converterParaEntidade()).converterParaDTO();
        body.setData(dto);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }
}