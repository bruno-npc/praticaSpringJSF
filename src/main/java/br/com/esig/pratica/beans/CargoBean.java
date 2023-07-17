package br.com.esig.pratica.beans;

import br.com.esig.pratica.dto.CargoDTO;
import br.com.esig.pratica.model.Cargo;
import br.com.esig.pratica.services.CargoService;
import br.com.esig.pratica.services.PessoaSalarioService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Named(value = "cargoBean")
@ViewScoped
public class CargoBean {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private PessoaSalarioService pessoaSalarioService;

    @Getter
    @Setter
    private List<String> listaCargo;

    @Getter
    @Setter
    private List<Cargo> cargoCompleteList;

    @Getter
    @Setter
    private CargoDTO cargoDTO;

    @Getter
    @Setter
    private BigDecimal salarioEdit;

    @PostConstruct
    public void init() {
        cargoDTO = new CargoDTO();
        loadPage();
    }

    private void loadPage() {
        loadAllCargos();
        loadCargos();
    }

    private void loadAllCargos(){
        cargoCompleteList = cargoService.buscarTodos();
    }

    private void loadCargos(){
        listaCargo = cargoService.listarCargos();
    }

    public void homePage() {
        try {
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/Home.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selecionarCargo(Long id, String nome, String salario) {
        cargoDTO.setId(id);
        cargoDTO.setNome(nome);
        salarioEdit = pessoaSalarioService.converterToNumerico(salario);
    }

    public void deletarCargo() {
        cargoService.deletarPorId(cargoDTO.getId());
        loadPage();
    }

    public void atualizarCargo() {
        cargoDTO.setSalario(pessoaSalarioService.converterToString(salarioEdit));
        cargoService.atualizarCargo(getCargoDTO());
        loadPage();
    }

    public void adicionarCargo() {
        cargoDTO.setSalario(pessoaSalarioService.converterToString(salarioEdit));
        cargoService.adicionarCargo(cargoDTO);
        loadPage();
    }
}
