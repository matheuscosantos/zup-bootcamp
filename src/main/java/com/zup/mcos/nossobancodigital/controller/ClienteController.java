package com.zup.mcos.nossobancodigital.controller;

import com.zup.mcos.nossobancodigital.dto.ClienteDTO;
import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.form.ClienteForm;
import com.zup.mcos.nossobancodigital.form.EnderecoForm;
import com.zup.mcos.nossobancodigital.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaClientePorId(@PathVariable(value = "id") Integer id){
        try{
            Optional<Cliente> cliente = clienteService.buscaClientePorId(id);
            if(cliente.isPresent()){
                return new ResponseEntity<>(new ClienteDTO(cliente.get()), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
}
