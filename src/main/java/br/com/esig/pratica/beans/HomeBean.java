package br.com.esig.pratica.beans;


import br.com.esig.pratica.dto.PessoaSalarioDTO;
import br.com.esig.pratica.model.PessoaSalario;
import br.com.esig.pratica.services.PessoaSalarioService;
import br.com.esig.pratica.services.PessoaService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Named(value = "homeBean")
@ViewScoped
public class HomeBean {

    @Autowired
    private PessoaSalarioService pessoaSalarioService;

    @Autowired
    private PessoaService pessoaService;

    @Getter
    @Setter
    private PessoaSalarioDTO dto = new PessoaSalarioDTO(0l, "", "", "");

    @Getter
    private List<PessoaSalarioDTO> dtoList;

    @Getter
    @Setter
    private String search;

    @Getter
    @Setter
    private BigDecimal salarioEdit;

    @Getter
    @Setter
    private int pageSize = 10;

    @Getter
    private int currentPage;

    @Getter
    private int totalPages;

    @PostConstruct
    public void init() {
        currentPage = 1;
        loadPage();
    }

    private void loadPage() {
        Page<PessoaSalarioDTO> page = pagePessoaSalario();
        dtoList = page.getContent();
        totalPages = page.getTotalPages();
    }

    public void atualizarPessoaSalario(){
        pessoaSalarioService.atualizarSalarioIndividual(dto.getId(), getSalarioEdit());
        reloadPage();
    }

    public void selecionarPessoa (Long id, String nome, String pessoaSalario){
        dto.setNome(nome);
        dto.setSalario(pessoaSalario);
        dto.setId(id);
        salarioEdit = pessoaSalarioService.converterToNumerico(pessoaSalario);
    }

    public void cargosPage() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/Cargo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restaurarTabela(){
        pessoaSalarioService.atualizarAll();
        reloadPage();
    }

    public void lastPage() {
        currentPage = totalPages;
        reloadPage();
    }

    public void firstPage() {
        currentPage = 1;
        reloadPage();
    }

    public void nextPage() {
        if (currentPage < totalPages) {
            currentPage++;
            reloadPage();
        }
    }

    public void previousPage() {
        if (currentPage > 1) {
            currentPage--;
            reloadPage();
        }
    }

    private Pageable createPageable(int pageNumber, int pageSize, String sortBy, Sort.Direction sortDirection) {
        Sort sort = Sort.by(sortDirection, sortBy);
        return PageRequest.of(pageNumber - 1, pageSize, sort);
    }

    public void deletarPessoa() {
        pessoaService.deletarPessoa(dto.getId().intValue());
    }

    public void reloadPage(){
        dtoList = pagePessoaSalario().getContent();
    }

    private Page<PessoaSalarioDTO> pagePessoaSalario (){
        return pessoaSalarioService.pessoaSalarioPage(getSearch(), createPageable(currentPage, 10, "id", Sort.Direction.DESC));
    }
}
