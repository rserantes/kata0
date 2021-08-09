package model;

import java.util.ArrayList;
import java.util.List;
import rules.PricingRule;

public class Checkout {

    private List<PricingRule> pricingRules;

    private List<Product> products = new ArrayList<>();

    private Integer totalAmount = 0;

    private PriceFormatter priceFormatter = new PriceFormatter();

    public Checkout(List<PricingRule> pricingRules) {
        this.pricingRules = pricingRules;
    }

    public void scan(Product product) {
        products.add(product);
        totalAmount = products.stream().map(Product::getAmount).reduce(0, Integer::sum);
        for (PricingRule pricingRule: pricingRules) {
            totalAmount -= pricingRule.getDiscount(products);
        }
    }

    public Integer getProductsQuantity() {
        return products.size();
    }

    public String getTotal() {
        return priceFormatter.format(totalAmount);
    }
}
