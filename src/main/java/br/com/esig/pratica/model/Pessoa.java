package br.com.esig.pratica.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "telefone", nullable = false)
    private String telefone;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;

    @OneToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

}