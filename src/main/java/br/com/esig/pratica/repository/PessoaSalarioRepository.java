package br.com.esig.pratica.repository;

import br.com.esig.pratica.dto.PessoaSalarioDTO;
import br.com.esig.pratica.model.PessoaSalario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaSalarioRepository extends JpaRepository<PessoaSalario, Long>{

    @Query("SELECT new br.com.esig.pratica.dto.PessoaSalarioDTO(ps.pessoa.id, ps.nome, c.nome, ps.salario) " +
            "FROM PessoaSalario ps " +
            "INNER JOIN Cargo c ON c.id = ps.pessoa.cargo.id " +
            "WHERE :pesquisa IS NULL OR ps.nome LIKE CONCAT('%', COALESCE(CAST(:pesquisa AS string), ''), '%') ")
    Page<PessoaSalarioDTO> findAllPessoaSalarioDTOPage(@Param("pesquisa") String pesquisa, Pageable pageable);

    @Query("SELECT ps FROM PessoaSalario ps WHERE ps.pessoa.id = :idPessoa")
    PessoaSalario findByPessoaId(@Param("idPessoa") Long idPessoa);

    @Modifying
    @Query("DELETE FROM PessoaSalario ps WHERE ps.pessoa.id = :id")
    void deleteByIdPessoa(@Param("id") int id);

    @Modifying
    @Query("UPDATE PessoaSalario ps SET ps.salario = :salario WHERE ps.pessoa.id = :id")
    void corrigirSalario(@Param("salario") String salario, @Param("id") Long id);
}
