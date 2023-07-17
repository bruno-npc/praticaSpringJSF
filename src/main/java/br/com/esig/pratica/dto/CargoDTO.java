package br.com.esig.pratica.dto;

import lombok.Data;

@Data
public class CargoDTO {

    private Long id;
    private String nome;
    private String salario;

    public CargoDTO(Long id, String nome, String salario){
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public CargoDTO() {
    }
}
