package com.zup.mcos.nossobancodigital.controller;

import com.zup.mcos.nossobancodigital.dto.ClienteDTO;
import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.enumeration.Estado;
import com.zup.mcos.nossobancodigital.form.ClienteForm;
import com.zup.mcos.nossobancodigital.form.EnderecoForm;
import com.zup.mcos.nossobancodigital.form.LogDeAprovacaoForm;
import com.zup.mcos.nossobancodigital.repository.ClienteRepository;
import com.zup.mcos.nossobancodigital.service.ClienteService;
import com.zup.mcos.nossobancodigital.service.ContaCorrenteService;
import com.zup.mcos.nossobancodigital.service.LogDeAprovacaoService;
import com.zup.mcos.nossobancodigital.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.time.LocalDate;
import java.util.HashMap;
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

    @Autowired
    ClienteRepository clienteRepository;


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
    public ResponseEntity<?> realizaCadastroBasico(@Valid @RequestBody ClienteForm cliente){
        if(LocalDate.now().getYear() - cliente.getDataDeNascimento().getYear() < 18){
            Cliente novoCliente = clienteService.salva(cliente);
            return new ResponseEntity<>(new ClienteDTO(novoCliente), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/{id}/endereco")
    @Transactional
    public ResponseEntity<?> realizaCadastroEndereco(@PathVariable Integer id, @Valid @RequestBody EnderecoForm enderecoForm){
        if(clienteRepository.getOne(id).getEstado() == Estado.COM_DADOS_BASICOS){
            Cliente cliente = clienteService.buscaClienteEAdicionaEndereco(id, enderecoForm);
            return new ResponseEntity<>(new ClienteDTO(cliente), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/{idCliente}/aprovacao")
    @Transactional
    public Map<String, String> aprovaOuReprovaDadosCadastrados(@PathVariable Integer idCliente, @Valid @RequestBody LogDeAprovacaoForm logDeAprovacaoForm){
        if(clienteRepository.getOne(idCliente).getEstado() == Estado.COM_ENDERECO) {
            LogDeAprovacao logDeAprovacaoSalvo = logDeAprovacaoService.alteraStatusDoClienteDeAcordoComAceitacao(idCliente, logDeAprovacaoForm);
            if(logDeAprovacaoSalvo.getEstado() == Estado.ACEITE){
                ContaCorrente contaCorrenteCriada = contaCorrenteService.criaContaCorrenteParaCliente(idCliente, logDeAprovacaoSalvo.getId());
            }
            return mensagemService.criaMensagemPorEstadoDeAceitacao(logDeAprovacaoSalvo);
        }
        Map<String, String> mensagem = new HashMap<String, String>();
        mensagem.put("mensagem", "Olá, agradecemos o contato, iremo verificar o motivo motivo pelos dados estarem incorretos e retornaremos o contato. Obrigado.");
        return  mensagem;
    }
}
