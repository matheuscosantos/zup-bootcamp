package com.zup.mcos.nossobancodigital.repository;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.TransferenciaInterna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaInternaRepository extends JpaRepository<TransferenciaInterna, Integer> {
}
