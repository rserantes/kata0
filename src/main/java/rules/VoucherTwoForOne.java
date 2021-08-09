package rules;

import java.util.List;
import model.Product;

public class VoucherTwoForOne implements PricingRule {

    @Override
    public long eligibleItems(List<Product> products) {
        return products.stream().filter(ProductRules::isVoucher).count() / 2;
    }

    @Override
    public Integer apply(List<Product> products) {
        return null;
    }
}
