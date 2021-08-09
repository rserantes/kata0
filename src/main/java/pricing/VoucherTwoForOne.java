package pricing;

import java.util.List;
import product.Product;
import product.ProductFactory;
import product.ProductRules;

public class VoucherTwoForOne implements PricingRule {

    private Integer eligibleItems(List<Product> products) {
        return (int)products.stream().filter(ProductRules::isVoucher).count() / 2;
    }

    @Override
    public Integer getDiscount(List<Product> products) {
        return eligibleItems(products) * ProductFactory.getVoucher().getAmount();
    }
}
