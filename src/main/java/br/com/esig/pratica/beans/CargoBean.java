package br.com.esig.pratica.beans;

import br.com.esig.pratica.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;

@Named(value = "cargoBean")
@ViewScoped
public class CargoBean {

    @Autowired
    private CargoService cargoService;

    @PostConstruct
    public void init() {
        loadPage();
    }

    private void loadPage() {

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
