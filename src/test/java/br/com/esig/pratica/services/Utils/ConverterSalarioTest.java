package br.com.esig.pratica.services.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

public class ConverterSalarioTest {

    private final ConverterSalario converterSalario = new ConverterSalario();

    @Test
    public void testFormatarValorMonetarioToString() {
        BigDecimal valor = new BigDecimal("5000.00");
        String valorFormatadoEsperado = "R$ 5.000,00";

        String valorFormatado = converterSalario.formatarValorMonetarioToString(valor);

        Assertions.assertEquals(valorFormatadoEsperado, valorFormatado);
    }

    @Test
    public void testConverterMonetarioToBigDecimal() {
        String valorString = "R$ 5.000,00";
        BigDecimal valorBigDecimalEsperado = new BigDecimal("5000.00");

        BigDecimal valorBigDecimal = converterSalario.converterMonetarioToBigDecimal(valorString);

        Assertions.assertEquals(valorBigDecimalEsperado, valorBigDecimal);
    }


}