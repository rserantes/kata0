package rules;

import java.util.List;
import model.Product;

public class PricingRules {

    public Integer getDiscountedPrice(List<Product> products) {
        return products.stream().map(Product::getAmount).reduce(0, Integer::sum);
    }
}
