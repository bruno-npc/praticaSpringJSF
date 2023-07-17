package br.com.esig.pratica.services;

import br.com.esig.pratica.model.Pessoa;
import br.com.esig.pratica.model.PessoaSalario;
import br.com.esig.pratica.repository.PessoaRepository;
import br.com.esig.pratica.repository.PessoaSalarioRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    final PessoaRepository pessoaRepository;

    final PessoaSalarioRepository pessoaSalarioRepository;

    public PessoaService(PessoaRepository pessoaRepository, PessoaSalarioRepository pessoaSalarioRepository) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaSalarioRepository = pessoaSalarioRepository;
    }

    public void atualizarPessoa(Pessoa pessoaEdit) {
        Pessoa pessoaExistente = pessoaRepository.findById(pessoaEdit.getId()).orElse(null);
        PessoaSalario pessoaSalario = pessoaSalarioRepository.findByPessoaId(pessoaEdit.getId());
        pessoaSalario.setNome(pessoaEdit.getNome());
        if (pessoaExistente != null) {
            pessoaRepository.save(pessoaEdit);
            pessoaSalarioRepository.save(pessoaSalario);
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
