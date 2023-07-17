package br.com.esig.pratica.repository;

import br.com.esig.pratica.model.Cargo;
import br.com.esig.pratica.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

    @Modifying
    @Query("DELETE FROM Pessoa p WHERE p.id = :id")
    void deleteByIdPessoa(@Param("id") Long id);

    @Query("SELECT c FROM Cargo c WHERE c.nome = :cargo")
    Cargo buscarCargo(@Param("cargo") String cargo);
}
