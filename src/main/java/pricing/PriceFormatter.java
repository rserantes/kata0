package pricing;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

public class PriceFormatter {

    private String pattern = "#0.00";

    private static String currency = "€";

    private NumberFormat formatter;

    public PriceFormatter() {
        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        otherSymbols.setDecimalSeparator('.');
        otherSymbols.setGroupingSeparator(',');
        formatter = new DecimalFormat(pattern, otherSymbols);

    }

    public String format(Integer amount) {
        return formatter.format(amount / 100.00) + " " + currency;
    }
}
