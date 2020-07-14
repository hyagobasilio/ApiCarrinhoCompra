package com.hyagohenrique.carrinho.service;

import java.util.List;

import com.hyagohenrique.carrinho.exception.NotFoundException;
import com.hyagohenrique.carrinho.irepository.ICarrinhoItemRespository;
import com.hyagohenrique.carrinho.irepository.IProdutoRepository;
import com.hyagohenrique.carrinho.iservice.ICarrinhoItemService;
import com.hyagohenrique.carrinho.iservice.ICarrinhoService;
import com.hyagohenrique.carrinho.model.Carrinho;
import com.hyagohenrique.carrinho.model.CarrinhoItem;
import com.hyagohenrique.carrinho.model.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoItemService implements ICarrinhoItemService {

    @Autowired
    private ICarrinhoService carrinhoService;

    @Autowired
    private ICarrinhoItemRespository carrinhoItemRepository;
    @Autowired
    private IProdutoRepository produtoRepository;

    @Override
    public CarrinhoItem salvar(CarrinhoItem carrinhoItem) {
        
        Carrinho carrinho = this.carrinhoService.getCarrinhoDoUsuarioLogado();
        carrinhoItem.setCarrinho(carrinho);

        Produto produto = this.produtoRepository.findById(carrinhoItem.getProduto().getId())
                        .orElseThrow(() -> new NotFoundException("Produto não encontrado!"));
        
        carrinhoItem.setValorVenda(produto.getPreco());
        carrinhoItem.setProduto(produto);

        return this.carrinhoItemRepository.save(carrinhoItem);
    }

    @Override
    public List<CarrinhoItem> listrarItensBuscandoPorIdDoCarrinho(Long id) {
        return this.carrinhoItemRepository.findAllByCarrinhoId(id);
    }

    @Override
    public void removerItem(Long id) {
        this.carrinhoItemRepository.deleteById(id);
    }
    
}