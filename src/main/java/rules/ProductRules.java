package rules;

import model.Product;

public class ProductRules {

    public static boolean isVoucher(Product product) {
        return product.getName().equals("Gift Card");
    }

}
