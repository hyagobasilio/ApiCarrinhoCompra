package com.hyagohenrique.carrinho.service;

import java.util.List;

import com.hyagohenrique.carrinho.exception.NotFoundException;
import com.hyagohenrique.carrinho.irepository.ICategoriaRepository;
import com.hyagohenrique.carrinho.iservice.ICategoriaService;
import com.hyagohenrique.carrinho.model.Categoria;
import com.hyagohenrique.carrinho.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaRespository;

    @Override
    public Categoria salvar(Categoria categoria) {
        return this.categoriaRespository.save(categoria);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return this.categoriaRespository.findAll();
    }

    @Override
    public void remover(Long id) {
        
        this.categoriaRespository.findById(id).orElseThrow(() -> new NotFoundException("Recurso com id: " + id + " não encontrado!"));
        
        this.categoriaRespository.deleteById(id);
    }
    
}