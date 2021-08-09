package rules;

import java.util.List;
import model.Product;

public interface PricingRule {

    long eligibleItems(List<Product> products);

    Integer apply(List<Product> products);
}
