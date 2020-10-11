package com.zup.mcos.nossobancodigital.repository;

import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {
    ContaCorrente findByContaAndAgencia(String conta, String agencia);
}
