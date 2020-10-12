package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.dto.ClienteEmailDTO;
import com.zup.mcos.nossobancodigital.dto.ContaEmailDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    void enviar(ClienteEmailDTO cliente, ContaEmailDTO contaCorrente);
}
