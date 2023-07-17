package br.com.esig.pratica.beans;


import br.com.esig.pratica.dto.PessoaDTO;
import br.com.esig.pratica.model.Pessoa;
import br.com.esig.pratica.services.CargoService;
import br.com.esig.pratica.services.PessoaSalarioService;
import br.com.esig.pratica.services.PessoaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "pessoaBean")
@ViewScoped
public class PessoaBean {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private PessoaSalarioService pessoaSalarioService;

    @Autowired
    private HomeBean homeBean;

    @Getter
    @Setter
    private Pessoa pessoa;

    @Getter
    @Setter
    private PessoaDTO pessoaDTO = new PessoaDTO();

    public void selecionarPessoa(Long id){
        pessoa = pessoaService.buscarPessoa(id);
    }

    public void atualizarPessoa() {
        pessoa.setCargo(cargoService.buscarPorNome(pessoa.getCargo().getNome()));
        pessoaSalarioService.corrigirSalario(pessoa.getCargo().getSalario(), pessoa.getId());
        pessoaService.atualizarPessoa(pessoa);
        homeBean.reloadPage();
    }

    public void adicionarPessoa() {
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(pessoaDTO.getNome());
        novaPessoa.setCidade(pessoaDTO.getCidade());
        novaPessoa.setEmail(pessoaDTO.getEmail());
        novaPessoa.setCep(pessoaDTO.getCep());
        novaPessoa.setEndereco(pessoaDTO.getEndereco());
        novaPessoa.setPais(pessoaDTO.getPais());
        novaPessoa.setUsuario(pessoaDTO.getUsuario());
        novaPessoa.setTelefone(pessoaDTO.getTelefone());
        novaPessoa.setDataNascimento(pessoaDTO.getDataNascimento());
        novaPessoa.setCargo(pessoaService.buscarCargo(pessoaDTO.getCargoNome()));

        pessoaService.inserirPessoa(novaPessoa);
        pessoaDTO = new PessoaDTO();
        homeBean.reloadPage();
    }
}
