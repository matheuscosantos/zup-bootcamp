package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.Endereco;
import com.zup.mcos.nossobancodigital.enumeration.Estado;
import com.zup.mcos.nossobancodigital.form.ClienteForm;
import com.zup.mcos.nossobancodigital.form.EnderecoForm;
import com.zup.mcos.nossobancodigital.repository.ClienteRepository;
import com.zup.mcos.nossobancodigital.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    public Cliente salva(ClienteForm clienteForm) {
        Cliente cliente = clienteForm.toModel(clienteForm);
        cliente.builder()
                .nome(clienteForm.getNome())
                .sobrenome(clienteForm.getSobrenome())
                .email(clienteForm.getEmail())
                .cnh(clienteForm.getCnh())
                .dataDeNascimento(clienteForm.getDataDeNascimento())
                .build();
        cliente.setEstado(Estado.COM_DADOS_BASICOS);
        Cliente novoCliente = clienteRepository.save(cliente);
        return novoCliente;
    }

    public Cliente buscaClienteEAdicionaEndereco(Integer idDoCliente, EnderecoForm enderecoForm) {
        Cliente cliente = clienteRepository.findById(idDoCliente).orElse(null);
        Endereco endereco = enderecoRepository.save(enderecoForm.toModel(enderecoForm));
        cliente.setEndereco(endereco);
        cliente.setEstado(Estado.COM_ENDERECO);
        return cliente;
    }

    public Optional<Cliente> buscaClientePorId(Integer id) {
        return clienteRepository.findById(id);
    }
}
