package rules;

import java.util.List;
import model.Product;

public interface PricingRule {

    Integer eligibleItems(List<Product> products);

    Integer getDiscount(List<Product> products);
}
