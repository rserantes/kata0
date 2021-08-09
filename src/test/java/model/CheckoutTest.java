package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rules.PricingRule;
import rules.TShirt3OrMoreDiscount;
import rules.VoucherTwoForOne;

class CheckoutTest {

    private Checkout checkout;

    @BeforeEach
    void setup() {
        List<PricingRule> pricingRules = new ArrayList<>();
        pricingRules.add(new VoucherTwoForOne());
        pricingRules.add(new TShirt3OrMoreDiscount());
        checkout = new Checkout(pricingRules);
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

    @Test
    @DisplayName("Example 1 should cost 32.50 €")
    void example1() {
        checkout.scan(ProductFactory.getVoucher());
        checkout.scan(ProductFactory.getTShirt());
        checkout.scan(ProductFactory.getPants());
        assertEquals("32.50 €", checkout.getTotal());
    }

    @Test
    @DisplayName("Example 2 should cost 25.00 €")
    void example2() {
        checkout.scan(ProductFactory.getVoucher());
        checkout.scan(ProductFactory.getTShirt());
        checkout.scan(ProductFactory.getVoucher());
        assertEquals("25.00 €", checkout.getTotal());
    }

    @Test
    @DisplayName("Example 3 should cost 81.00 €")
    void example3() {
        checkout.scan(ProductFactory.getTShirt());
        checkout.scan(ProductFactory.getTShirt());
        checkout.scan(ProductFactory.getTShirt());
        checkout.scan(ProductFactory.getVoucher());
        checkout.scan(ProductFactory.getTShirt());
        assertEquals("81.00 €", checkout.getTotal());
    }

    @Test
    @DisplayName("Example 4 should cost 74.50 €")
    void example4() {
        checkout.scan(ProductFactory.getVoucher());
        checkout.scan(ProductFactory.getTShirt());
        checkout.scan(ProductFactory.getVoucher());
        checkout.scan(ProductFactory.getVoucher());
        checkout.scan(ProductFactory.getPants());
        checkout.scan(ProductFactory.getTShirt());
        checkout.scan(ProductFactory.getTShirt());
        assertEquals("74.50 €", checkout.getTotal());
    }

}