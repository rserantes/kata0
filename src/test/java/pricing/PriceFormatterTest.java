package pricing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pricing.PriceFormatter;

class PriceFormatterTest {

    private PriceFormatter priceFormatter = new PriceFormatter();

    @Test
    @DisplayName("An amount of 500 should format as 5.00 €")
    void format500() {
        assertEquals("5.00 €", priceFormatter.format(500));
    }

    @Test
    @DisplayName("An amount of 2000 should format as 20.00 €")
    void format2000() {
        assertEquals("20.00 €", priceFormatter.format(2000));
    }

    @Test
    @DisplayName("An amount of 750 should format as 7.50 €")
    void format750() {
        assertEquals("7.50 €", priceFormatter.format(750));
    }

    @Test
    @DisplayName("An amount of 3250 should format as 32.50 €")
    void format3250() {
        assertEquals("32.50 €", priceFormatter.format(3250));
    }

    @Test
    @DisplayName("An amount of 2500 should format as 25.00 €")
    void format2500() {
        assertEquals("25.00 €", priceFormatter.format(2500));
    }

    @Test
    @DisplayName("An amount of 8100 should format as 81.00 €")
    void format8100() {
        assertEquals("81.00 €", priceFormatter.format(8100));
    }

    @Test
    @DisplayName("An amount of 7450 should format as 74.50 €")
    void format7450() {
        assertEquals("74.50 €", priceFormatter.format(7450));
    }

}