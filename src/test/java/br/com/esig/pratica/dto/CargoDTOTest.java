package br.com.esig.pratica.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CargoDTOTest {

    @Test
    public void testConstructorAndGetters() {
        Long id = 1L;
        String nome = "Gerente";
        String salario = "5000";
        BigDecimal salarioNumerico = new BigDecimal("5000.00");

        CargoDTO cargoDTO = new CargoDTO();

        cargoDTO.setId(id);
        cargoDTO.setNome(nome);
        cargoDTO.setSalario(salario);
        cargoDTO.setSalarioNumerico(salarioNumerico);

        Assertions.assertEquals(id, cargoDTO.getId());
        Assertions.assertEquals(nome, cargoDTO.getNome());
        Assertions.assertEquals(salario, cargoDTO.getSalario());
        Assertions.assertEquals(salarioNumerico, cargoDTO.getSalarioNumerico());
    }

    @Test
    public void testDefaultConstructor() {
        CargoDTO cargoDTO = new CargoDTO();

        Assertions.assertNull(cargoDTO.getId());
        Assertions.assertNull(cargoDTO.getNome());
        Assertions.assertNull(cargoDTO.getSalario());
        Assertions.assertNull(cargoDTO.getSalarioNumerico());
    }

    @Test
    public void testSetters() {
        CargoDTO cargoDTO = new CargoDTO();

        Long id = 2L;
        cargoDTO.setId(id);
        Assertions.assertEquals(id, cargoDTO.getId());

        String nome = "Assistente";
        cargoDTO.setNome(nome);
        Assertions.assertEquals(nome, cargoDTO.getNome());

        String salario = "3000";
        cargoDTO.setSalario(salario);
        Assertions.assertEquals(salario, cargoDTO.getSalario());

        BigDecimal salarioNumerico = new BigDecimal("3000.00");
        cargoDTO.setSalarioNumerico(salarioNumerico);
        Assertions.assertEquals(salarioNumerico, cargoDTO.getSalarioNumerico());
    }
}