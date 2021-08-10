package pricing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.Product;
import product.ProductFactory;
import product.ProductRules;
import purchase.CheckoutItem;

class TShirt3OrMoreDiscountTest {

    private PricingRule shirtsDiscount = new TShirt3OrMoreDiscount();

    @Test
    @DisplayName("Zero eligible shirts when only one on checkout")
    void zeroEligibleWhenOneVoucher() {
        List<CheckoutItem> items = new ArrayList<>();
        items.add(new CheckoutItem(ProductFactory.getTShirt()));
        shirtsDiscount.apply(items);

        assertEquals(0, shirtsDiscount.getDiscount(items));
        assertEquals(2000, items.get(0).getPrice());
    }

    @Test
    @DisplayName("Three eligible shirts when three on checkout")
    void oneEligibleWhenTwoVouchers() {
        List<CheckoutItem> items = new ArrayList<>();
        items.add(new CheckoutItem(ProductFactory.getTShirt()));
        items.add(new CheckoutItem(ProductFactory.getTShirt()));
        items.add(new CheckoutItem(ProductFactory.getTShirt()));


        shirtsDiscount.apply(items);

        assertEquals(300, shirtsDiscount.getDiscount(items));
        assertEquals(1900, items.get(0).getPrice());
        assertEquals(1900, items.get(1).getPrice());
        assertEquals(1900, items.get(2).getPrice());
    }

    @Test
    @DisplayName("25 eligible shirts when 25 on checkout")
    void severalEligible() {
        List<CheckoutItem> items = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            items.add(new CheckoutItem(ProductFactory.getTShirt()));
        }

        shirtsDiscount.apply(items);

        assertEquals(2500, shirtsDiscount.getDiscount(items));
        for (CheckoutItem item : items) {
            assertEquals(1900, item.getPrice());
        }

    }

    @Test
    @DisplayName("25 eligible shirts when 25 on checkout and other items")
    void severalEligibleWithOtherItems() {
        List<CheckoutItem> items = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            items.add(new CheckoutItem(ProductFactory.getTShirt()));
            items.add(new CheckoutItem(ProductFactory.getPants()));
        }

        shirtsDiscount.apply(items);

        assertEquals(2500, shirtsDiscount.getDiscount(items));
        for (CheckoutItem item : items) {
            if (ProductRules.isTShirt(item.getProduct())) {
                assertEquals(1900, item.getPrice());
            }
        }
    }

}