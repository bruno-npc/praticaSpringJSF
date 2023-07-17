package br.com.esig.pratica.beans;


import br.com.esig.pratica.model.Pessoa;
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
    private HomeBean homeBean;

    @Getter
    @Setter
    private Pessoa pessoa;

    public void selecionarPessoa(Long id){
        pessoa = pessoaService.buscarPessoa(id);
    }

    public void atualizarPessoa() {
        pessoaService.atualizarPessoa(pessoa);
        homeBean.reloadPage();
    }
}
