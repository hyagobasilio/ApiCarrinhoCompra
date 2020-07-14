package com.hyagohenrique.carrinho.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyagohenrique.carrinho.dto.CategoriaDTO;
import com.hyagohenrique.carrinho.iservice.ICategoriaService;
import com.hyagohenrique.carrinho.model.Categoria;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CategoriaControllerTest {

    private static final Long ID = 1L;
    private static final String NOME = "INFORMATICA";
    private static final String URL = "/categoria";

    @MockBean
    ICategoriaService service;

    @Autowired
    MockMvc mvc;

    @Test
    @WithMockUser
    public void testeSalvarNovaCategoria() throws JsonProcessingException, Exception {
        Categoria categoria = new Categoria();
        categoria.setId(ID);
        categoria.setNome(NOME);

        BDDMockito.given(this.service.salvar(Mockito.any(Categoria.class))).willReturn(categoria);

        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad()).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(ID))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.nome").value(NOME));
    }

    public String getJsonPayLoad() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(getMockCategoriaDTO());
    }

    public CategoriaDTO getMockCategoriaDTO() {
        CategoriaDTO categoria = new CategoriaDTO();
        categoria.setNome(NOME);
        return categoria;
    }
    
}