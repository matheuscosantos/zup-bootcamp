package com.zup.mcos.nossobancodigital.controller;

import com.zup.mcos.nossobancodigital.dto.ClienteDTO;
import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.enumeration.Estado;
import com.zup.mcos.nossobancodigital.form.ClienteForm;
import com.zup.mcos.nossobancodigital.form.EnderecoForm;
import com.zup.mcos.nossobancodigital.form.LogDeAprovacaoForm;
import com.zup.mcos.nossobancodigital.service.ClienteService;
import com.zup.mcos.nossobancodigital.service.ContaCorrenteService;
import com.zup.mcos.nossobancodigital.service.LogDeAprovacaoService;
import com.zup.mcos.nossobancodigital.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    LogDeAprovacaoService logDeAprovacaoService;

    @Autowired
    MensagemService mensagemService;

    @Autowired
    ContaCorrenteService contaCorrenteService;


    @GetMapping("/{id}")
    public ResponseEntity<?> buscaClientePorId(@PathVariable(value = "id") Integer id){
        try{
            Optional<Cliente> cliente = clienteService.buscaClientePorId(id);
            if(cliente.isPresent()){
                return new ResponseEntity<>(new ClienteDTO(cliente.get()), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    @Transactional
    public ResponseEntity<?> realizaCadastroBasico(@RequestBody ClienteForm cliente){
        Cliente novoCliente = clienteService.salva(cliente);
        return new ResponseEntity<>(new ClienteDTO(novoCliente), HttpStatus.OK);
    }

    @PutMapping("/{id}/endereco")
    @Transactional
    public ResponseEntity<?> realizaCadastroEndereco(@PathVariable Integer id, @RequestBody EnderecoForm enderecoForm){
        Cliente cliente = clienteService.buscaClienteEAdicionaEndereco(id, enderecoForm);
        return new ResponseEntity<>(new ClienteDTO(cliente), HttpStatus.OK);
    }

    @PostMapping("/{idCliente}/aprovacao")
    @Transactional
    public Map<String, String> aprovaOuReprovaDadosCadastrados(@PathVariable Integer idCliente, @RequestBody LogDeAprovacaoForm logDeAprovacaoForm){
        LogDeAprovacao logDeAprovacaoSalvo = logDeAprovacaoService.alteraStatusDoClienteDeAcordoComAceitacao(idCliente, logDeAprovacaoForm);
        if(logDeAprovacaoSalvo.getEstado() == Estado.ACEITE){
            ContaCorrente contaCorrenteCriada = contaCorrenteService.criaContaCorrenteParaCliente(idCliente, logDeAprovacaoSalvo.getId());
        }
        return mensagemService.criaMensagemPorEstadoDeAceitacao(logDeAprovacaoSalvo);
    }
}
