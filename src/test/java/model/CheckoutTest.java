package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rules.PricingRules;

class CheckoutTest {

    private Checkout checkout;

    @BeforeEach
    void setup() {
        checkout = new Checkout(new PricingRules());
    }

    @Test
    @DisplayName("Scanning a product adds it to the current checkout")
    void scanningAProductAddsIt() {
        assertEquals(0, checkout.getProductsQuantity());
        assertEquals("0.00 €", checkout.getTotal());
        checkout.scan(ProductFactory.getPants());
        assertEquals(1, checkout.getProductsQuantity());
        assertEquals("7.50 €", checkout.getTotal());

    }

}