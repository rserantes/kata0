package pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import product.ProductFactory;
import product.ProductRules;
import purchase.CheckoutItem;

class VoucherTwoForOneTest {

    private PricingRule voucherSpecial = new VoucherTwoForOne();

    @Test
    @DisplayName("Zero free vouchers when only one on checkout")
    void zeroEligibleWhenOneVoucher() {
        List<CheckoutItem> items = new ArrayList<>();
        items.add(new CheckoutItem(ProductFactory.getVoucher()));

        voucherSpecial.apply(items);

        assertEquals(0, voucherSpecial.getDiscount(items));
        allSecondVouchersAreFree(items);
    }

    @Test
    @DisplayName("One free voucher when two on checkout")
    void oneEligibleWhenTwoVouchers() {
        List<CheckoutItem> items = new ArrayList<>();
        items.add(new CheckoutItem(ProductFactory.getVoucher()));
        items.add(new CheckoutItem(ProductFactory.getVoucher()));

        voucherSpecial.apply(items);

        assertEquals(500, voucherSpecial.getDiscount(items));
        allSecondVouchersAreFree(items);
    }

    @Test
    @DisplayName("12 free vouchers when 25 on checkout")
    void severalEligible() {
        List<CheckoutItem> items = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            items.add(new CheckoutItem(ProductFactory.getVoucher()));
        }

        voucherSpecial.apply(items);

        assertEquals(12 * 500, voucherSpecial.getDiscount(items));
        allSecondVouchersAreFree(items);
    }

    @Test
    @DisplayName("12 free vouchers when 25 on checkout and other items")
    void severalEligibleWithOtherItems() {
        List<CheckoutItem> items = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            items.add(new CheckoutItem(ProductFactory.getVoucher()));
            items.add(new CheckoutItem(ProductFactory.getPants()));
        }

        voucherSpecial.apply(items);

        assertEquals(12 * 500, voucherSpecial.getDiscount(items));
        allSecondVouchersAreFree(items);
    }

    private int numberOfFullPricedVouchers(List<CheckoutItem> items) {
        return (int)items.stream()
                .filter(item -> ProductRules.isVoucher(item.getProduct()))
                .filter(voucher -> voucher.getPrice().equals(500))
                .count();
    }

    private int numberOfFreeVouchers(List<CheckoutItem> items) {
        return (int)items.stream()
                .filter(item -> ProductRules.isVoucher(item.getProduct()))
                .filter(voucher -> voucher.getPrice().equals(0))
                .count();
    }

    private void allSecondVouchersAreFree(List<CheckoutItem> items) {
        assertTrue(numberOfFullPricedVouchers(items) - numberOfFreeVouchers(items) < 2);
    }

}