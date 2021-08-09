package rules;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import model.Product;
import model.ProductFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VoucherTwoForOneTest {

    private PricingRule voucherSpecial = new VoucherTwoForOne();

    @Test
    @DisplayName("Zero eligible vouchers when only one on checkout")
    void zeroEligibleWhenOneVoucher() {
        List<Product> products = new ArrayList<>();
        products.add(ProductFactory.getVoucher());

        assertEquals(0, voucherSpecial.eligibleItems(products));
        assertEquals(500, voucherSpecial.apply(products));
    }

    @Test
    @DisplayName("One eligible voucher when two on checkout")
    void oneEligibleWhenTwoVouchers() {
        List<Product> products = new ArrayList<>();
        products.add(ProductFactory.getVoucher());
        products.add(ProductFactory.getVoucher());

        assertEquals(1, voucherSpecial.eligibleItems(products));
        assertEquals(500, voucherSpecial.apply(products));
    }

    @Test
    @DisplayName("12 eligible voucher when 25 on checkout")
    void severalEligible() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            products.add(ProductFactory.getVoucher());
        }

        assertEquals(12, voucherSpecial.eligibleItems(products));
        assertEquals(13 * 500, voucherSpecial.apply(products));
    }

    @Test
    @DisplayName("12 eligible voucher when 25 on checkout and other items")
    void severalEligibleWithOtherItems() {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            products.add(ProductFactory.getVoucher());
            products.add(ProductFactory.getPants());
        }

        assertEquals(12, voucherSpecial.eligibleItems(products));
        assertEquals((13 * 500) + (25 * 750), voucherSpecial.apply(products));
    }

}