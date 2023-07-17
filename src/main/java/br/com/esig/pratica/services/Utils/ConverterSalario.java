package br.com.esig.pratica.services.Utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

@Component
public class ConverterSalario {

    public String formatarValorMonetarioToString(BigDecimal valor) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("R$ #,##0.00", symbols);
        return decimalFormat.format(valor);
    }

    public BigDecimal converterMonetarioToBigDecimal(String valorString) {
        String valorSemSimbolo = valorString.replace("R$", "");
        String valorSemPonto = valorSemSimbolo.replace(".", "");
        String valorSemVirgula = valorSemPonto.replace(",", ".");
        String valorSemEspaco = valorSemVirgula.replace(" ", "");

        return new BigDecimal(valorSemEspaco);
    }
}
