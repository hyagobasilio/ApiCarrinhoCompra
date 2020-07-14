package com.hyagohenrique.carrinho.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import com.hyagohenrique.carrinho.dto.CategoriaDTO;
import com.hyagohenrique.carrinho.iservice.ICategoriaService;
import com.hyagohenrique.carrinho.model.Categoria;
import com.hyagohenrique.carrinho.response.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<Response<List<CategoriaDTO>>> listar() {
        Response<List<CategoriaDTO>> response = new Response<>();
        List<CategoriaDTO> lista = this.categoriaService.listarCategorias().stream().map(i -> i.converterParaDTO()).collect(Collectors.toList());
        response.setData(lista);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping()
    public ResponseEntity<Response<CategoriaDTO>> salvar(@RequestBody CategoriaDTO dto, BindingResult result ){
        
        Response<CategoriaDTO> response = new Response<>();
        if(result.hasErrors()) {
            result.getAllErrors().forEach(e -> {
                response.getErrors().add(e.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        
        Categoria categoria = this.categoriaService.salvar(dto.converterParEntidade());

        response.setData(categoria.converterParaDTO());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> deletar(@PathParam("id") Long id) {

        this.categoriaService.remover(id);
        Response<String> response = new Response<>();
        response.setData("Categoria removida com sucesso!" );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
        
    
}