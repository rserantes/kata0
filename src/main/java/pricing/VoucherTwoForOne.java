package pricing;

import java.util.List;
import product.Product;
import product.ProductFactory;
import product.ProductRules;
import pricing.PricingRule;

public class VoucherTwoForOne implements PricingRule {

    @Override
    public Integer eligibleItems(List<Product> products) {
        return (int)products.stream().filter(ProductRules::isVoucher).count() / 2;
    }

    @Override
    public Integer getDiscount(List<Product> products) {
        return eligibleItems(products) * ProductFactory.getVoucher().getAmount();
    }
}
