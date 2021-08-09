package rules;

import java.util.List;
import model.Product;
import model.ProductFactory;

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
