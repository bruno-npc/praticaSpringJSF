package br.com.esig.pratica.dto;

import lombok.Data;

@Data
public class PessoaSalarioDTO {

    private String nome;
    private String cargo;
    private String salario;

    public PessoaSalarioDTO (String nome, String cargo, String salario){
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

}
