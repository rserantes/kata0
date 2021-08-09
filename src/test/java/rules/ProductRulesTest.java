package rules;

import static org.junit.jupiter.api.Assertions.*;

import model.ProductFactory;
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

}