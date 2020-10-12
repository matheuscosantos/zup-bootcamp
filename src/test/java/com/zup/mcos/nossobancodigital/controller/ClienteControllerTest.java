package com.zup.mcos.nossobancodigital.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveCriarUmaConta() throws Exception {
        URI uri = new URI("/api/v1/cliente");
        String json = " {\n" +
                    "       \"cnh\": \"3333333333\",\n" +
                    "       \"dataDeNascimento\": \"2019-02-02\",\n" +
                    "       \"email\": \"oliveiramatheus666@gmail.com\",\n" +
                    "       \"nome\": \"Matheus\",\n" +
                    "       \"sobrenome\": \"Oliveira\"\n" +
                    "  }";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                            .content(json)
                            .contentType(MediaType.APPLICATION_JSON))
                                    .andExpect(MockMvcResultMatchers
                                            .status().isOk());
    }


    @Test
    public void deveRetornarUmaConta() throws Exception{
        URI uri = new URI("/api/v1/cliente/1/endereco");
        String json = "{\n" +
                    "        \"cnh\": \"3333333333\",\n" +
                    "        \"dataDeNascimento\": \"2019-02-02\",\n" +
                    "        \"email\": \"oliveiramatheus666@gmail.com\",\n" +
                    "        \"nome\": \"Matheus\",\n" +
                    "        \"sobrenome\": \"Oliveira\"\n" +
                    "  }";
        mockMvc.perform(MockMvcRequestBuilders.put(uri)
                                .content(json)
                                .contentType(MediaType.APPLICATION_JSON))
                                    .andExpect(MockMvcResultMatchers
                                        .status().isOk());
    }

    @Test
    public void buscaClientePorId() throws Exception{
        URI uri = new URI("/api/v1/cliente/1");
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status()
                .isOk());
    }

    @Test
    public void buscaClientePorIdQueNaoExiste() throws Exception{
        URI uri = new URI("/api/v1/cliente/10");
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status()
                        .isNotFound());
    }

    @Test
    public void buscaClientePorIdComFormatoErrado() throws Exception{
        URI uri = new URI("/api/v1/cliente/10m");
        mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andExpect(MockMvcResultMatchers.status()
                        .isBadRequest());
    }

    @Test
    public void aprovaDadosDoCadastroEAlteraOStatusParaAceite() throws  Exception{
        URI uri = new URI("/api/v1/cliente/3/aprovacao");
        String json = "    {\n" +
                      "        \"estado\":\"ACEITE\"\n" +
                      "    }";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers
                        .status().isOk());
    }

    @Test
    public void aprovaDadosDoCadastroEAlteraOStatusParaNaoAceite() throws  Exception{
        URI uri = new URI("/api/v1/cliente/3/aprovacao");
        String json = "{\n" +
                      "     \"estado\":\"NAO_ACEITE\"\n" +
                      "}";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().isOk());
    }

    @Test
    public void realizaTransferenciaEntreDuasContasDoMesmoBanco() throws Exception{
        URI uri = new URI("/api/v1/conta-corrente/transferencia-interna");
        String json = "{\n" +
                      "  \"agenciaDeDestino\": 9711,\n" +
                      "  \"numeroDaContaDeDestino\": 12044205,\n" +
                      "  \"agenciaDaContaDeOrigem\": 9711,\n" +
                      "  \"numeroDaContaDeOrigem\": 22252525,\n" +
                      "  \"valor\": 500\n" +
                      "}";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers
                        .status().isOk());
    }

    @Test
    public void realizaSolicitacaoDeTransferenciaParaUmaContaDeOutroBanco() throws Exception{
        URI uri = new URI("/api/v1/conta-corrente/transferencia-externa");
        String json = "{\n" +
                      "  \"agenciaDeOrigem\": \"9711\",\n" +
                      "  \"contaDeOrigem\": \"22252525\",\n" +
                      "  \"agenciaDeDestino\": \"7777\",\n" +
                      "  \"codigoDoBancoDeDestino\": \"01\",\n" +
                      "  \"contaDeDestino\": \"77777777\",\n" +
                      "  \"dataDaSolicitacao\": \"2020-12-10\",\n" +
                      "  \"descricao\": \"Descrição\",\n" +
                      "  \"documento\": \"44.547.893-1\",\n" +
                      "  \"favoritado\": true,\n" +
                      "  \"nomeDoBancoDeDestino\": \"Banco do Brasil\",\n" +
                      "  \"nomeDoFavorecido\": \"Viviane\",\n" +
                      "  \"tipoDeConta\": \"CORRENTE\",\n" +
                      "  \"valor\": 300\n" +
                      "}";
        mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status().isOk());
    }

}

