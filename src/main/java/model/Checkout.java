package model;

import java.util.ArrayList;
import java.util.List;
import rules.PricingRules;

public class Checkout {

    private PricingRules pricingRules;

    private List<Product> products = new ArrayList<>();

    public Checkout(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void scan(Product product) {
        products.add(product);
    }

    public Integer getProductsQuantity() {
        return products.size();
    }
}
