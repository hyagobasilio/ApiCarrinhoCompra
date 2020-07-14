package com.hyagohenrique.carrinho.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

import com.hyagohenrique.carrinho.irepository.ICarrinhoItemRespository;
import com.hyagohenrique.carrinho.irepository.ICarrinhoRepository;
import com.hyagohenrique.carrinho.irepository.ICategoriaRepository;
import com.hyagohenrique.carrinho.irepository.IProdutoRepository;
import com.hyagohenrique.carrinho.irepository.IUsuarioRepository;
import com.hyagohenrique.carrinho.model.Carrinho;
import com.hyagohenrique.carrinho.model.CarrinhoItem;
import com.hyagohenrique.carrinho.model.Categoria;
import com.hyagohenrique.carrinho.model.Produto;
import com.hyagohenrique.carrinho.model.Usuario;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CarrinhoItemRepositoryTest {
    
    @Autowired
    private ICarrinhoItemRespository carrinhoItemRepository;
    @Autowired
    private ICarrinhoRepository carrinhoRepository;
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Autowired
    private IProdutoRepository produtoRepository;
    @Autowired 
    private ICategoriaRepository categoriaRepository;


    private static final String NOME_PRODUTO = "MONITOR TV";
    private static final BigDecimal VALOR_PRODUTO = new BigDecimal(200.00);
    private static final BigDecimal QUANTIDADE_PRODUTO = new BigDecimal(2.00);


    @Before
    public void beforeEach() {
        /* Usuario usuario = new Usuario();
        usuario.setNome("Fulano");
        usuario.setEmail("email@emial.com");
        usuario.setPassword("password");
        this.usuarioRepository.save(usuario);
        
        Carrinho c = new Carrinho();
        c.setUsuario(usuario);
        carrinhoRepository.save(c);

        Categoria categoria = new Categoria();
        categoria.setNome("INFORMATICA");
        categoriaRepository.save(categoria);

        Produto p = new Produto();
        p.setCategoria(categoria);
        p.setNome("MONITOR 22P 4K");
        p.setPreco(new BigDecimal(150.00));
        produtoRepository.save(p);

        CarrinhoItem ci = new CarrinhoItem();
        ci.setCarrinho(c);
        ci.setProduto(p);
        ci.setQuantidade(new BigDecimal(2));
        ci.setValorVenda(p.getPreco());
        carrinhoItemRepository.save(ci); */

    }

    @Test
    public void listarItemDoCarrinhoPorCarrinhoId() {
        Usuario usuario = new Usuario();
        usuario.setNome("Fulano");
        usuario.setEmail("email@emial.com");
        usuario.setPassword("password");
        this.usuarioRepository.save(usuario);
        
        Carrinho c = new Carrinho();
        c.setUsuario(usuario);
        carrinhoRepository.save(c);

        Categoria categoria = new Categoria();
        categoria.setNome("INFORMATICA");
        categoriaRepository.save(categoria);

        Produto p = new Produto();
        p.setCategoria(categoria);
        p.setNome(NOME_PRODUTO);
        p.setPreco(VALOR_PRODUTO);
        produtoRepository.save(p);

        CarrinhoItem ci = new CarrinhoItem();
        ci.setCarrinho(c);
        ci.setProduto(p);
        ci.setQuantidade(QUANTIDADE_PRODUTO);
        ci.setValorVenda(p.getPreco());
        carrinhoItemRepository.save(ci);

        List<CarrinhoItem> items = this.carrinhoItemRepository.findAllByCarrinhoId(1L);

        assertNotNull(items);
        assertFalse(items.isEmpty());
        assertEquals(1, items.size());
        
    }
}