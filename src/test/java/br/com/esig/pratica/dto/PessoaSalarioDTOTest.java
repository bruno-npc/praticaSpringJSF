package br.com.esig.pratica.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaSalarioDTOTest {

    @Test
    public void testConstructorAndGetters() {
        Long id = 1L;
        String nome = "João";
        String cargo = "Gerente";
        String salario = "5000";

        PessoaSalarioDTO pessoaSalarioDTO = new PessoaSalarioDTO(id, nome, cargo, salario);

        Assertions.assertEquals(id, pessoaSalarioDTO.getId());
        Assertions.assertEquals(nome, pessoaSalarioDTO.getNome());
        Assertions.assertEquals(cargo, pessoaSalarioDTO.getCargo());
        Assertions.assertEquals(salario, pessoaSalarioDTO.getSalario());
    }

    @Test
    public void testSetters() {
        PessoaSalarioDTO pessoaSalarioDTO = new PessoaSalarioDTO(null, null, null, null);

        Long id = 2L;
        pessoaSalarioDTO.setId(id);
        Assertions.assertEquals(id, pessoaSalarioDTO.getId());

        String nome = "Maria";
        pessoaSalarioDTO.setNome(nome);
        Assertions.assertEquals(nome, pessoaSalarioDTO.getNome());

        String cargo = "Analista";
        pessoaSalarioDTO.setCargo(cargo);
        Assertions.assertEquals(cargo, pessoaSalarioDTO.getCargo());

        String salario = "3000";
        pessoaSalarioDTO.setSalario(salario);
        Assertions.assertEquals(salario, pessoaSalarioDTO.getSalario());
    }

}