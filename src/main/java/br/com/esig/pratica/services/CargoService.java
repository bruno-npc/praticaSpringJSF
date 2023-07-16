package br.com.esig.pratica.services;

import br.com.esig.pratica.model.Cargo;
import br.com.esig.pratica.repository.CargoRepository;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    final CargoRepository repository;

    public CargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public Cargo buscarCargo(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletarCargo(Long id) {
        repository.deleteById(id);
    }

    public void inserirCargo(Cargo cargo) {
        repository.save(cargo);
    }

    public void atualizarCargo(Cargo cargo) {
        if (repository.existsById(Long.valueOf(cargo.getId()))) {
            repository.save(cargo);
        }
    }

}
