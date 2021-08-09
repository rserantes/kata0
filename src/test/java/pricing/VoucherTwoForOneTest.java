package pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.ProductFactory;
import purchase.CheckoutItem;

class VoucherTwoForOneTest {

    private PricingRule voucherSpecial = new VoucherTwoForOne();

    @Test
    @DisplayName("Zero eligible vouchers when only one on checkout")
    void zeroEligibleWhenOneVoucher() {
        List<CheckoutItem> items = new ArrayList<>();
        items.add(new CheckoutItem(ProductFactory.getVoucher()));

        assertEquals(0, voucherSpecial.getDiscount(items));
    }

    @Test
    @DisplayName("One eligible voucher when two on checkout")
    void oneEligibleWhenTwoVouchers() {
        List<CheckoutItem> items = new ArrayList<>();
        items.add(new CheckoutItem(ProductFactory.getVoucher()));
        items.add(new CheckoutItem(ProductFactory.getVoucher()));

        assertEquals(500, voucherSpecial.getDiscount(items));
    }

    @Test
    @DisplayName("12 eligible voucher when 25 on checkout")
    void severalEligible() {
        List<CheckoutItem> items = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            items.add(new CheckoutItem(ProductFactory.getVoucher()));
        }

        assertEquals(12 * 500, voucherSpecial.getDiscount(items));
    }

    @Test
    @DisplayName("12 eligible voucher when 25 on checkout and other items")
    void severalEligibleWithOtherItems() {
        List<CheckoutItem> items = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            items.add(new CheckoutItem(ProductFactory.getVoucher()));
            items.add(new CheckoutItem(ProductFactory.getPants()));
        }

        assertEquals(12 * 500, voucherSpecial.getDiscount(items));
    }

}