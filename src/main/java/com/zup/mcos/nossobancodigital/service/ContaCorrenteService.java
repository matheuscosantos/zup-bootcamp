package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import org.springframework.stereotype.Service;

@Service
public interface ContaCorrenteService {
    ContaCorrente criaContaCorrenteParaCliente(Integer idCliente, Integer idLog);
}
