package pricing;

import java.util.List;
import product.Product;

public interface PricingRule {

    Integer getDiscount(List<Product> products);

}
