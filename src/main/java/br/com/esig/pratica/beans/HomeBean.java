package br.com.esig.pratica.beans;


import br.com.esig.pratica.dto.PessoaSalarioDTO;
import br.com.esig.pratica.model.PessoaSalario;
import br.com.esig.pratica.services.PessoaSalarioService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;

@Named(value = "homeBean")
@ViewScoped
public class HomeBean {

    @Autowired
    private PessoaSalarioService pessoaSalarioService;

    @Getter
    private List<PessoaSalarioDTO> dto;

    @Getter
    @Setter
    private String nome;

    private int currentPage;
    private int totalPages;

    @Getter
    @Setter
    private PessoaSalario pessoaSalarioUpdate = new PessoaSalario();

    @PostConstruct
    public void init() {
        currentPage = 1;
        loadPage();
    }

    private void loadPage() {
        Pageable pageable = createPageable(currentPage, 10, "id", Sort.Direction.DESC);
        Page<PessoaSalarioDTO> page = pessoaSalarioService.pessoaSalarioPage(pageable);
        dto = page.getContent();
        totalPages = page.getTotalPages();
    }

    public void selecionarPessoa (Long id){
        pessoaSalarioUpdate.setId(id);
    }

    public void atualizarPessoaSalario() {
        pessoaSalarioService.atualizar(pessoaSalarioUpdate.getId(), nome);
    }


    private Pageable createPageable(int pageNumber, int pageSize, String sortBy, Sort.Direction sortDirection) {
        Sort sort = Sort.by(sortDirection, sortBy);
        return PageRequest.of(pageNumber - 1, pageSize, sort);
    }

    public void alterarPage() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/Cargo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
