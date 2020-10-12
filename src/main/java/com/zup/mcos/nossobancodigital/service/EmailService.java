package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import org.springframework.stereotype.Service;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    public void enviar(Cliente cliente, ContaCorrente contaCorrente){
        try{
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("nossobancodigital@gmail.com", "password"));
            email.setSSLOnConnect(true);

            email.setFrom("springbootalura@gmail.com");
            email.setSubject("Criação de conta bancária");
            email.setMsg("Olá " + cliente.getNome() + ". Acabamos de confirmar a criação da sua conta bancária." +
                                                      "\nOs dados são: " + "" +
                                                      "\nConta: " + "" +
                                                      "\nAgência: "+ "");
            email.addTo(cliente.getEmail());
            email.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
