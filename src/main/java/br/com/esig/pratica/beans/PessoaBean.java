package br.com.esig.pratica.beans;


import br.com.esig.pratica.model.Pessoa;
import br.com.esig.pratica.services.PessoaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;

@Named(value = "pessoaB")
@ViewScoped
public class PessoaBean {

    @Autowired
    private PessoaService pessoaService;

    @Getter
    private List<Pessoa> pessoas;

    private int currentPage;
    private int totalPages;

    @PostConstruct
    public void init() {
        currentPage = 1;
        loadPage();
    }

    private void loadPage() {
        Pageable pageable = createPageable(currentPage, 10, "id", Sort.Direction.DESC);
        Page<Pessoa> page = pessoaService.pessoaPage(pageable);
        pessoas = page.getContent();
        totalPages = page.getTotalPages();
    }

    public void nextPage() {
        if (currentPage < totalPages) {
            currentPage++;
            Page<Pessoa> nextPage = pessoaService.pessoaPage(createPageable(currentPage, 10, "id", Sort.Direction.DESC));
            pessoas = nextPage.getContent();
        }
    }

    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
            Page<Pessoa> previousPage = pessoaService.pessoaPage(createPageable(currentPage, 10, "id", Sort.Direction.DESC));
            pessoas = previousPage.getContent();
        }
    }

    private Pageable createPageable(int pageNumber, int pageSize, String sortBy, Sort.Direction sortDirection) {
        Sort sort = Sort.by(sortDirection, sortBy);
        return PageRequest.of(pageNumber - 1, pageSize, sort);
    }

    public void alterarSalarios() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/Cargo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
