package model;

import java.util.ArrayList;
import java.util.List;
import rules.PricingRules;

public class Checkout {

    private PricingRules pricingRules;

    private List<Product> products = new ArrayList<>();

    private Integer totalAmount = 0;

    private PriceFormatter priceFormatter = new PriceFormatter();

    public Checkout(PricingRules pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void scan(Product product) {
        products.add(product);
        totalAmount = pricingRules.getDiscountedPrice(products);
    }

    public Integer getProductsQuantity() {
        return products.size();
    }

    public String getTotal() {
        return priceFormatter.format(totalAmount);
    }
}
