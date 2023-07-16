package br.com.esig.pratica.services;

import br.com.esig.pratica.dto.PessoaSalarioDTO;
import br.com.esig.pratica.repository.PessoaSalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PessoaSalarioService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    final PessoaSalarioRepository repository;

    public PessoaSalarioService(PessoaSalarioRepository repository) {
        this.repository = repository;
    }

    public Page<PessoaSalarioDTO> pessoaSalarioPage(Pageable pageable){
        return repository.findAllPessoaSalarioDTOPage(pageable);
    }

    public void atualizarAll() {
        String sql = "SELECT insert_pessoa_salario()";
        jdbcTemplate.execute(sql);
    }


}
