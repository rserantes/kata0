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
    public Integer apply(List<Product> products) {
        Integer discountedPrice = products.stream().map(Product::getAmount).reduce(0, Integer::sum);
        discountedPrice -= eligibleItems(products) * ProductFactory.getVoucher().getAmount();
        return discountedPrice;
    }
}
