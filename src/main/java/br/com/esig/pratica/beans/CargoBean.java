package br.com.esig.pratica.beans;

import br.com.esig.pratica.dto.CargoDTO;
import br.com.esig.pratica.model.Cargo;
import br.com.esig.pratica.services.CargoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import javax.el.MethodExpression;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.util.List;

@Named(value = "cargoBean")
@ViewScoped
public class CargoBean {

    @Autowired
    private CargoService cargoService;

    @Getter
    @Setter
    private List<String> listaCargo;

    @Getter
    @Setter
    private List<Cargo> cargoCompleteList;

    @Getter
    @Setter
    private CargoDTO cargoDTO;

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
        cargoDTO.setSalario(salario);
    }

    public void deletarCargo() {

    }

    public void atualizarCargo() {

    }
}
