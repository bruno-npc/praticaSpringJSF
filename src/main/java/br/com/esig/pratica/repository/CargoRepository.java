package br.com.esig.pratica.repository;

import br.com.esig.pratica.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long>{

    @Query("SELECT DISTINCT c.nome FROM Cargo c")
    List<String> listarCargos();

    @Query("SELECT c FROM Cargo c WHERE c.nome = :nome")
    Cargo buscarPorNome(@Param("nome") String nome);
}
