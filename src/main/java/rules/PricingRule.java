package rules;

import java.util.List;
import model.Product;

public interface PricingRule {

    Integer eligibleItems(List<Product> products);

    Integer apply(List<Product> products);
}
