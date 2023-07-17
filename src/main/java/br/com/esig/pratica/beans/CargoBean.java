package br.com.esig.pratica.beans;

import br.com.esig.pratica.services.CargoService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
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

    @PostConstruct
    public void init() {
        loadPage();
    }

    private void loadPage() {
        loadCargos();
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
}
