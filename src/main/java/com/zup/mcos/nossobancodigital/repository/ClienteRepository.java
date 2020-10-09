package com.zup.mcos.nossobancodigital.repository;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
