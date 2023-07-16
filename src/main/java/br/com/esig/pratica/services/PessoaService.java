package br.com.esig.pratica.services;

import br.com.esig.pratica.model.Pessoa;
import br.com.esig.pratica.repository.PessoaRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void atualizarPessoa(Pessoa pessoaEdit) {
        Pessoa pessoaExistente = pessoaRepository.findById(pessoaEdit.getId()).orElse(null);
        if (pessoaExistente != null) {
            pessoaRepository.save(pessoaEdit);
        }
        else {
            System.out.println("Erro, editar pessoa.");
        }
    }

    public void inserirPessoa(Pessoa novaPessoa) {
        try {
            pessoaRepository.save(novaPessoa);
        } catch (Exception e) {
            System.out.println("Erro ao inserir pessoa: " + e.getMessage());
        }
    }

    public void deletarPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa buscarPessoa(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

}
