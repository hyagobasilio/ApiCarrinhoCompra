package com.hyagohenrique.carrinho.service;

import java.util.List;
import java.util.Optional;

import com.hyagohenrique.carrinho.exception.NotFoundException;
import com.hyagohenrique.carrinho.irepository.ICarrinhoRepository;
import com.hyagohenrique.carrinho.irepository.IUsuarioRepository;
import com.hyagohenrique.carrinho.iservice.ICarrinhoService;
import com.hyagohenrique.carrinho.model.Carrinho;
import com.hyagohenrique.carrinho.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService implements ICarrinhoService {

    @Autowired
    private ICarrinhoRepository carrinhoRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private ICarrinhoService carrinhoService;

    @Override
    public Carrinho salvar(Usuario usuario) {
        Carrinho carrinho = new Carrinho();
        carrinho.setUsuario(usuario);

        return this.carrinhoRepository.save(carrinho);
    }

    @Override
    public Carrinho getCarrinhoPorId(Long id) {
        return this.carrinhoRepository.findById(id).orElseThrow(() -> new NotFoundException("Carrinho não encontrado!"));
    }

    @Override
    public Carrinho getCarrinhoDoUsuarioLogado() {
 
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<Usuario> usuario = this.usuarioRepository.findByEmail(user.getUsername());
        
        List<Carrinho> carrinhos = this.listCarrinhosPorIdDoUsuario(usuario.get().getId());
        
        if (carrinhos.isEmpty()) {

            return this.carrinhoService.salvar(usuario.get()); 

        }
        return carrinhos.get(0);
    }

    @Override
    public List<Carrinho> listCarrinhosPorIdDoUsuario(Long idUsuario) {
        return this.carrinhoRepository.findAllByUsuarioId(idUsuario);
    }
}