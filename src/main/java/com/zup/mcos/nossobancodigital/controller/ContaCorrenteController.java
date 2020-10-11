package com.zup.mcos.nossobancodigital.controller;

import com.zup.mcos.nossobancodigital.dto.TransferenciaInternaDTO;
import com.zup.mcos.nossobancodigital.entity.TransferenciaInterna;
import com.zup.mcos.nossobancodigital.form.TransferenciaInternaForm;
import com.zup.mcos.nossobancodigital.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/conta-corrente")
public class ContaCorrenteController {

    @Autowired
    TransferenciaService transferenciaService;

    @PostMapping("/transferencia-interna")
    public ResponseEntity<?> realizaTransferenciaInterna(@RequestBody TransferenciaInternaForm transferenciaForm){
        TransferenciaInterna transferenciaInterna = transferenciaService.solicitaTransferencia(transferenciaForm);
        return new ResponseEntity<>(new TransferenciaInternaDTO(transferenciaInterna), HttpStatus.OK);
    }

}
