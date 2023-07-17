package br.com.esig.pratica.services;

import br.com.esig.pratica.model.Cargo;
import br.com.esig.pratica.model.Pessoa;
import br.com.esig.pratica.model.PessoaSalario;
import br.com.esig.pratica.repository.PessoaRepository;
import br.com.esig.pratica.repository.PessoaSalarioRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {

    final PessoaRepository pessoaRepository;

    final PessoaSalarioRepository pessoaSalarioRepository;

    @Autowired
    private PessoaSalarioService pessoaSalarioService;

    @Getter
    @Setter
    private Long idCargo;


    public PessoaService(PessoaRepository pessoaRepository, PessoaSalarioRepository pessoaSalarioRepository) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaSalarioRepository = pessoaSalarioRepository;
    }

    @Transactional
    public void atualizarPessoa(Pessoa pessoaEdit) {
        Pessoa pessoaExistente = pessoaRepository.findById(pessoaEdit.getId()).orElse(null);
        PessoaSalario pessoaSalario = pessoaSalarioRepository.findByPessoaId(pessoaEdit.getId());
        pessoaSalario.setNome(pessoaEdit.getNome());
        if (pessoaExistente != null) {
            pessoaRepository.save(pessoaEdit);
            pessoaSalarioRepository.save(pessoaSalario);
        }
    }

    @Transactional
    public void inserirPessoa(Pessoa pessoa) {
        pessoa.setId(pessoaRepository.count() + 1);
        pessoaRepository.save(pessoa);
        pessoaSalarioService.atualizar(pessoa);
    }

    @Transactional
    public void deletarPessoa(Long id) {
        pessoaSalarioRepository.deleteByIdPessoa(id);
        pessoaRepository.deleteByIdPessoa(id);
    }

    public Pessoa buscarPessoa(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public Cargo buscarCargo(String cargo) {
        return pessoaRepository.buscarCargo(cargo);
    }
}
