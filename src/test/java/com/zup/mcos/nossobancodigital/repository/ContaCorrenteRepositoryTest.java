package com.zup.mcos.nossobancodigital.repository;

import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class ContaCorrenteRepositoryTest {

    @Autowired
    ContaCorrenteRepository repository;

    @Test
    public void deveRetornarUmaContaPorContaEAgencia(){
        String conta = "12044205";
        String agencia = "9711";
        Integer idDoCliente = 3;
        Integer idDoLogDeAprovacao = 1;
        BigDecimal saldo = new BigDecimal("-500.00");
        ContaCorrente contaCorrente = repository.findByContaAndAgencia(conta, agencia);
        Assert.assertEquals(agencia, contaCorrente.getAgencia());
        Assert.assertEquals(conta, contaCorrente.getConta());
        Assert.assertEquals(idDoCliente, contaCorrente.getCliente().getId());
        Assert.assertEquals(idDoLogDeAprovacao, contaCorrente.getLogDeAprovacao().getId());
        Assert.assertEquals(saldo, contaCorrente.getSaldo());
    }
}

