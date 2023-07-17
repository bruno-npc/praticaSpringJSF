package br.com.esig.pratica.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaDTOTest {

        @Test
        public void testConstructorAndGetters() {
            String nome = "João";
            String cidade = "São Paulo";
            String email = "joao@example.com";
            String cep = "12345-678";
            String endereco = "Rua A";
            String pais = "Brasil";
            String usuario = "joao123";
            String telefone = "123456789";
            String dataNascimento = "1990-01-01";
            String cargoNome = "Gerente";

            PessoaDTO pessoaDTO = new PessoaDTO();
            pessoaDTO.setNome("João");
            pessoaDTO.setCidade("São Paulo");
            pessoaDTO.setEmail("joao@example.com");
            pessoaDTO.setCep("12345-678");
            pessoaDTO.setEndereco("Rua A");
            pessoaDTO.setPais("Brasil");
            pessoaDTO.setUsuario("joao123");
            pessoaDTO.setTelefone("123456789");
            pessoaDTO.setDataNascimento("1990-01-01");
            pessoaDTO.setCargoNome("Gerente");

            Assertions.assertEquals(nome, pessoaDTO.getNome());
            Assertions.assertEquals(cidade, pessoaDTO.getCidade());
            Assertions.assertEquals(email, pessoaDTO.getEmail());
            Assertions.assertEquals(cep, pessoaDTO.getCep());
            Assertions.assertEquals(endereco, pessoaDTO.getEndereco());
            Assertions.assertEquals(pais, pessoaDTO.getPais());
            Assertions.assertEquals(usuario, pessoaDTO.getUsuario());
            Assertions.assertEquals(telefone, pessoaDTO.getTelefone());
            Assertions.assertEquals(dataNascimento, pessoaDTO.getDataNascimento());
            Assertions.assertEquals(cargoNome, pessoaDTO.getCargoNome());
        }

        @Test
        public void testDefaultConstructor() {
            PessoaDTO pessoaDTO = new PessoaDTO();

            Assertions.assertNull(pessoaDTO.getNome());
            Assertions.assertNull(pessoaDTO.getCidade());
            Assertions.assertNull(pessoaDTO.getEmail());
            Assertions.assertNull(pessoaDTO.getCep());
            Assertions.assertNull(pessoaDTO.getEndereco());
            Assertions.assertNull(pessoaDTO.getPais());
            Assertions.assertNull(pessoaDTO.getUsuario());
            Assertions.assertNull(pessoaDTO.getTelefone());
            Assertions.assertNull(pessoaDTO.getDataNascimento());
            Assertions.assertNull(pessoaDTO.getCargoNome());
        }

        @Test
        public void testSetters() {
            PessoaDTO pessoaDTO = new PessoaDTO();

            String nome = "Maria";
            pessoaDTO.setNome(nome);
            Assertions.assertEquals(nome, pessoaDTO.getNome());

            String cidade = "Rio de Janeiro";
            pessoaDTO.setCidade(cidade);
            Assertions.assertEquals(cidade, pessoaDTO.getCidade());

            String email = "maria@example.com";
            pessoaDTO.setEmail(email);
            Assertions.assertEquals(email, pessoaDTO.getEmail());

            String cep = "98765-432";
            pessoaDTO.setCep(cep);
            Assertions.assertEquals(cep, pessoaDTO.getCep());

            String endereco = "Rua B";
            pessoaDTO.setEndereco(endereco);
            Assertions.assertEquals(endereco, pessoaDTO.getEndereco());

            String pais = "Brasil";
            pessoaDTO.setPais(pais);
            Assertions.assertEquals(pais, pessoaDTO.getPais());

            String usuario = "maria456";
            pessoaDTO.setUsuario(usuario);
            Assertions.assertEquals(usuario, pessoaDTO.getUsuario());

            String telefone = "987654321";
            pessoaDTO.setTelefone(telefone);
            Assertions.assertEquals(telefone, pessoaDTO.getTelefone());

            String dataNascimento = "1995-02-20";
            pessoaDTO.setDataNascimento(dataNascimento);
            Assertions.assertEquals(dataNascimento, pessoaDTO.getDataNascimento());

            String cargoNome = "Analista";
            pessoaDTO.setCargoNome(cargoNome);
            Assertions.assertEquals(cargoNome, pessoaDTO.getCargoNome());
        }
}
