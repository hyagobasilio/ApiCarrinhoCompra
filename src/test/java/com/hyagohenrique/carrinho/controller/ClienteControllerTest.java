package com.hyagohenrique.carrinho.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hyagohenrique.carrinho.dto.ClienteDTO;
import com.hyagohenrique.carrinho.model.Usuario;
import com.hyagohenrique.carrinho.service.UsuarioService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteControllerTest {

    private static final Long ID = 1L;
    private static final String EMAIL = "email@teste.com";
    private static final String NOME = "User Test";
    private static final String SENHA = "123456";
    private static final String URL = "/cliente";

    @MockBean
    UsuarioService service;

    @Autowired
    MockMvc mvc;

    @Test
    public void testSalvarNovoCliente() throws JsonProcessingException, Exception {
        Usuario usuario = getMockClienteDTO().converterParaEntidade();
        usuario.setId(ID);
        BDDMockito.given(this.service.save(Mockito.any(Usuario.class))).willReturn(usuario);

        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayLoad()).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(ID))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.nome").value(NOME))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.email").value(EMAIL))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.senha").doesNotExist());
    }

    public String getJsonPayLoad() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(getMockClienteDTO());
    }

    public ClienteDTO getMockClienteDTO() {
        ClienteDTO dto = new ClienteDTO();
        dto.setEmail(EMAIL);
        dto.setNome(NOME);
        dto.setSenha(SENHA);
        dto.setId(ID);
        return dto;
    }
    
}