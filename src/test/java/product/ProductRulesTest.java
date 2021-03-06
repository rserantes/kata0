package product;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductRulesTest {

    @Test
    @DisplayName("A Gift Card is a Voucher")
    void giftCardIsAVoucher() {
        assertTrue(ProductRules.isVoucher(ProductFactory.getVoucher()));
    }

    @Test
    @DisplayName("A T-Shirt is not a Voucher")
    void tShirtIsNotAVoucher() {
        assertFalse(ProductRules.isVoucher(ProductFactory.getTShirt()));
    }

    @Test
    @DisplayName("A Pant is not a Voucher")
    void pantIsNotAVoucher() {
        assertFalse(ProductRules.isVoucher(ProductFactory.getPants()));
    }

    @Test
    @DisplayName("A Gift Card is not a T-Shirt")
    void giftCardIsNotATShirt() {
        assertFalse(ProductRules.isTShirt(ProductFactory.getVoucher()));
    }

    @Test
    @DisplayName("A Summer T-Shirt is a T-Shirt")
    void summerTShirtIsATShirt() {
        assertTrue(ProductRules.isTShirt(ProductFactory.getTShirt()));
    }

    @Test
    @DisplayName("A Pant is not a T-Shirt")
    void pantIsNotATShirt() {
        assertFalse(ProductRules.isTShirt(ProductFactory.getPants()));
    }

}