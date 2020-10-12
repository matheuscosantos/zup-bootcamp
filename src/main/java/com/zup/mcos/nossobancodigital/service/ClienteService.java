package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.form.ClienteForm;
import com.zup.mcos.nossobancodigital.form.EnderecoForm;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClienteService {
    Cliente salva(ClienteForm clienteForm);
    Cliente buscaClienteEAdicionaEndereco(Integer idDoCliente, EnderecoForm enderecoForm);
    Optional<Cliente> buscaClientePorId(Integer id);
}
