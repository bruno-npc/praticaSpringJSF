package br.com.esig.pratica.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CargoDTO {

    private Long id;
    private String nome;
    private String salario;
    private BigDecimal salarioNumerico;

    public CargoDTO() {
    }
}
