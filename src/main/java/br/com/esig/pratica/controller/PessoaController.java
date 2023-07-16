package br.com.esig.pratica.controller;

import br.com.esig.pratica.model.Pessoa;
import br.com.esig.pratica.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Pessoas")
public class PessoaController
{

    @Autowired
    private PessoaRepository pessoaRepositorio;

    @GetMapping
    public List<Pessoa> listar() {
        return pessoaRepositorio.findAll();
    }

    @PostMapping
    public void incluir(@RequestBody Pessoa pessoa) {
        pessoaRepositorio.save(pessoa);
    }

    @PutMapping
    public void alterar(@RequestBody Pessoa pessoa){
        pessoaRepositorio.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id){
        pessoaRepositorio.deleteById(id.longValue());
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> ler(@PathVariable Integer id){
        return pessoaRepositorio.findById(id.longValue());
    }

}
