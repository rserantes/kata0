package pricing;

import java.util.List;
import product.Product;

public interface PricingRule {

    Integer eligibleItems(List<Product> products);

    Integer getDiscount(List<Product> products);
}
