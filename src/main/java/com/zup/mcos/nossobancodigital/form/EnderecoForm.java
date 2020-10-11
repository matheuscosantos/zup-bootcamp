package com.zup.mcos.nossobancodigital.form;

import com.zup.mcos.nossobancodigital.entity.Endereco;
import lombok.*;

@Getter
@NoArgsConstructor
public class EnderecoForm {
    private String cep;
    private String rua;
    private String bairro;
    private String complemento;
    private String cidade;
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
