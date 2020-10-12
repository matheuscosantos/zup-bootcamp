package com.zup.mcos.nossobancodigital.form;

import com.zup.mcos.nossobancodigital.entity.Endereco;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class EnderecoForm {
    @NotEmpty(message = "O CEP precisa ser preenchido")
    @NotNull(message = "O CEP precisa ser preenchido")
    private String cep;
    @NotEmpty(message = "A rua precisa ser preenchido")
    @NotNull(message = "A rua precisa ser preenchido")
    private String rua;
    @NotEmpty(message = "O bairro precisa ser preenchido")
    @NotNull(message = "O bairro precisa ser preenchido")
    private String bairro;
    private String complemento;
    @NotEmpty(message = "A cidade precisa ser preenchida")
    @NotNull(message = "A cidade precisa ser preenchida")
    private String cidade;
    @NotEmpty(message = "O estado precisa ser preenchido")
    @NotNull(message = "O estado precisa ser preenchido")
    private String estado;

    public Endereco toModel(EnderecoForm enderecoForm) {
        Endereco endereco = Endereco.builder()
                .bairro(enderecoForm.getBairro())
                .cep(enderecoForm.getCep())
                .rua(enderecoForm.getRua())
                .complemento(enderecoForm.getComplemento())
                .cidade(enderecoForm.getCidade())
                .estado(enderecoForm.getEstado())
                .build();
        return endereco;
    }

}
