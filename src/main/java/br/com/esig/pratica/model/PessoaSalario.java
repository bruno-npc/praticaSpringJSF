package br.com.esig.pratica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class PessoaSalario {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "salario", nullable = false)
    private String salario;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

}