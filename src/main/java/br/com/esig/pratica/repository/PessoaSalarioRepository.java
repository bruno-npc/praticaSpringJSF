package br.com.esig.pratica.repository;

import br.com.esig.pratica.dto.PessoaSalarioDTO;
import br.com.esig.pratica.model.PessoaSalario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaSalarioRepository extends JpaRepository<PessoaSalario, Long>{

    @Query("SELECT new br.com.esig.pratica.dto.PessoaSalarioDTO(ps.nome, c.nome, ps.salario) " +
            "FROM PessoaSalario ps " +
            "INNER JOIN Cargo c ON c.id = ps.pessoa.cargo.id")
    Page<PessoaSalarioDTO> findAllPessoaSalarioDTOPage(Pageable pageable);

}
