package br.com.esig.pratica.services;

import br.com.esig.pratica.dto.PessoaSalarioDTO;
import br.com.esig.pratica.model.PessoaSalario;
import br.com.esig.pratica.repository.PessoaSalarioRepository;
import br.com.esig.pratica.services.Utils.ConverterSalario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class PessoaSalarioService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    final PessoaSalarioRepository repository;

    private final ConverterSalario conversor;

    public PessoaSalarioService(PessoaSalarioRepository repository, ConverterSalario conversor) {
        this.repository = repository;
        this.conversor = conversor;
    }

    public Page<PessoaSalarioDTO> pessoaSalarioPage(String pesquisa, Pageable pageable){
        return repository.findAllPessoaSalarioDTOPage(
                pesquisa,
                pageable);
    }

    @Transactional
    public void atualizarAll() {
        String sql = "SELECT update_pessoa_salario()";
        jdbcTemplate.execute(sql);
    }

    @Transactional
    public void atualizarSalarioIndividual(Long idPessoa, BigDecimal salario){
        String novoSalario = conversor.formatarValorMonetarioToString(salario);
        PessoaSalario updatePessoaSalario = repository.findByPessoaId(idPessoa);
        if (updatePessoaSalario != null) {
            updatePessoaSalario.setSalario(novoSalario);
            repository.save(updatePessoaSalario);
        }
    }

    public BigDecimal converterToNumerico (String valor){
        return conversor.converterMonetarioToBigDecimal(valor);
    }

    public String converterToString(BigDecimal salarioEdit) {
        return conversor.formatarValorMonetarioToString(salarioEdit);
    }
}
