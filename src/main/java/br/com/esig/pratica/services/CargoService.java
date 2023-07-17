package br.com.esig.pratica.services;

import br.com.esig.pratica.dto.CargoDTO;
import br.com.esig.pratica.model.Cargo;
import br.com.esig.pratica.repository.CargoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CargoService {

    final CargoRepository repository;

    public CargoService(CargoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void atualizarCargo(CargoDTO dto) {
        repository.saveDTO(dto, dto.getId().intValue());
    }

    @Transactional
    public void adicionarCargo(CargoDTO dto) {
        Cargo cargo = new Cargo();
        cargo.setId(gerarId());
        cargo.setNome(dto.getNome());
        cargo.setSalario(dto.getSalario());
        repository.save(cargo);
    }

    @Transactional
    public void deletarPorId(Long id){
        repository.deletarCargo(id.intValue());
    }

    private Integer gerarId() {
        Long novoId = repository.count() + 1l;
        return novoId.intValue();
    }

    public List<String> listarCargos() {
        return repository.listarCargos();
    }

    public Cargo buscarPorNome(String nome) {
        return repository.buscarPorNome(nome);
    }

    public List<Cargo> buscarTodos() {
        return repository.findAll();
    }
}
