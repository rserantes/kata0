package pricing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import product.ProductFactory;

class TShirt3OrMoreDiscountTest {

    private PricingRule shirtsDiscount = new TShirt3OrMoreDiscount();

    @Test
    @DisplayName("Zero eligible shirts when only one on checkout")
    void zeroEligibleWhenOneVoucher() {
        List<Product> products = new ArrayList<>();
        products.add(ProductFactory.getTShirt());

        assertEquals(0, shirtsDiscount.getDiscount(products));
    }

    @Test
    @DisplayName("Three eligible shirts when three on checkout")
    void oneEligibleWhenTwoVouchers() {
        List<Product> products = new ArrayList<>();
        products.add(ProductFactory.getTShirt());
        products.add(ProductFactory.getTShirt());
        products.add(ProductFactory.getTShirt());

        assertEquals(300, shirtsDiscount.getDiscount(products));
    }

    @Test
    @DisplayName("25 eligible shirts when 25 on checkout")
    void severalEligible() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            products.add(ProductFactory.getTShirt());
        }

        assertEquals(2500, shirtsDiscount.getDiscount(products));
    }

    @Test
    @DisplayName("25 eligible shirts when 25 on checkout and other items")
    void severalEligibleWithOtherItems() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            products.add(ProductFactory.getTShirt());
            products.add(ProductFactory.getPants());
        }

        assertEquals(2500, shirtsDiscount.getDiscount(products));
    }

}