package br.com.esig.pratica.dto;

import lombok.Data;

@Data
public class PessoaSalarioDTO {

    private Long id;
    private String nome;
    private String cargo;
    private String salario;

    public PessoaSalarioDTO (Long id, String nome, String cargo, String salario){
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

}
