package org.retail.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.faces.convert.Converter;

/**
 * Base currency: Japanese yen
 *
 * @author Paul Kulitski
 */
@Stateless
public class ConverterBean implements Serializable {
    private final static Logger logger = Logger.getLogger(ConverterBean.class.getName());

    private BigDecimal yenRate = new BigDecimal("83.062");
    private BigDecimal euroRate = new BigDecimal("0.0093016");

    public BigDecimal dollarToYen(BigDecimal dollars) {
        BigDecimal result = dollars.multiply(yenRate);
        return result.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal yenToEuro(BigDecimal yen) {
        BigDecimal result = yen.multiply(euroRate);
        return result.setScale(2, BigDecimal.ROUND_UP);
    }

    public BigDecimal getYenRate() {
        return yenRate;
    }

    public void setYenRate(BigDecimal yenRate) {
        this.yenRate = yenRate;
    }

    public BigDecimal getEuroRate() {
        return euroRate;
    }

    public void setEuroRate(BigDecimal euroRate) {
        this.euroRate = euroRate;
    }
}
