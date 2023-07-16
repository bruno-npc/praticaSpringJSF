package br.com.esig.pratica.repository;

import br.com.esig.pratica.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
