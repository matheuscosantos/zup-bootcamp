package com.zup.mcos.nossobancodigital.form;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ClienteForm {
    @NotEmpty(message = "O nome precisa ser preenchido")
    @NotNull(message = "O nome precisa ser preenchido")
    private String nome;
    @NotEmpty(message = "O sobrenome precisa ser preenchido")
    @NotNull(message = "O sobrenome precisa ser preenchido")
    private String sobrenome;
    @Email(message = "E-mail não é válido")
    @NotNull(message = "Por favor insira um email")
    @Size(max = 100)
    private String email;
    @NotEmpty(message = "O número do cnh precisa ser preenchido")
    @NotNull(message = "O número do cnh precisa ser preenchido")
    private String cnh;
    @NotNull(message = "A data de nascimento precisa ser adicionada")
    @Past
    private LocalDate dataDeNascimento;

    public Cliente toModel(ClienteForm clienteForm) {
        Cliente cliente = Cliente.builder()
                .cnh(clienteForm.getCnh())
                .dataDeNascimento(clienteForm.getDataDeNascimento())
                .email(clienteForm.getEmail())
                .nome(clienteForm.getNome())
                .sobrenome(clienteForm.getSobrenome())
                .build();
        return cliente;
    }
}